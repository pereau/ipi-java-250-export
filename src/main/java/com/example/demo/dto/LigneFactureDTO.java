package com.example.demo.dto;


/**
 * Created by Kayne on 09/04/2018.
 */
public class LigneFactureDTO {

    private String designation;
    private Integer quantite;
    private Double prixUnitaire;
    private FactureDTO factureDTO;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

	public FactureDTO getFactureDTO() {
		return factureDTO;
	}

	public void setFactureDTO(FactureDTO factureDTO) {
		this.factureDTO = factureDTO;
	}
    
    
}
