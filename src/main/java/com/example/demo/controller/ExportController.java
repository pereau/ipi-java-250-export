package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.service.ClientService;
import com.example.demo.service.FactureService;
import com.example.demo.service.export.ExportCSVService;
import com.example.demo.service.export.ExportPDFITextService;
import com.example.demo.service.export.ExportXLSXService;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/")
public class ExportController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExportCSVService exportCSVService;
    
    @Autowired
    ExportXLSXService exportXLSXService;

    @Autowired
    private FactureService factureService;

    @Autowired
    private ExportPDFITextService exportPDFITextService;

    @GetMapping("/clients/csv")
    public void clientsCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"clients.csv\"");
        List<ClientDTO> clients = clientService.findAllClients();
        exportCSVService.export(response.getWriter(), clients);
    }
    
    @GetMapping("/clients/xls")
    public void clientsXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"clients.xlsx\"");
        List<ClientDTO> clients = clientService.findAllClients();
        //List<FactureDTO> factures = factureService.findAllFactures();
        exportXLSXService.export(response.getOutputStream(), clients);
    }
    
    @GetMapping("/facture/xls/{clientId}")
    public void factureClientXLSX(@PathVariable("clientId") Long clientId, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"clients" + clientId + ".xlsx\"");
        List<FactureDTO> factures = factureService.findByClientId(clientId);
        exportXLSXService.editFactureXLSX(response.getOutputStream(), factures);
    }

    @GetMapping("/factures/{id}/pdf")
    public void facturePDF(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"facture " + id + ".pdf\"");
        FactureDTO facture = factureService.findById(id);
        exportPDFITextService.export(response.getOutputStream(), facture);
    }

}
