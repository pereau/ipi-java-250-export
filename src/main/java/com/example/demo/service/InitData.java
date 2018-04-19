package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    public void insertTestData() {

        Client client  = new Client();
        client.setNom("PETRILLO");
        client.setPrenom("Alexandre");
        client.setAge(30);
        client.setCp(69000);
        client.setCommune("Lyon");
        em.persist(client);

        Article article1 = new Article();
        article1.setLibelle("Carte mère ASROCK 2345");
        article1.setPrix(79.90);
        em.persist(article1);
        
        Article article1_2 = new Article();
        article1_2.setLibelle("Carte mère ASROCK 2346");
        article1_2.setPrix(89.90);
        em.persist(article1_2);
        
        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article1);
        ligneFacture1.setQuantite(1);
        em.persist(ligneFacture1);
        
        LigneFacture ligneFacture1_2 = new LigneFacture();
        ligneFacture1_2.setFacture(facture);
        ligneFacture1_2.setArticle(article1_2);
        ligneFacture1_2.setQuantite(2);
        em.persist(ligneFacture1_2);
        
        Client client2  = new Client();
        client2.setNom("Coltrane");
        client2.setPrenom("John");
        client2.setAge(40);
        client2.setCp(93100);
        client2.setCommune("Gif sur Yvette");
        em.persist(client2);

        Article article2 = new Article();
        article2.setLibelle("Saxophone Alto");
        article2.setPrix(3000.0);
        em.persist(article2);

        Facture facture2 = new Facture();
        facture2.setClient(client2);
        em.persist(facture2);

        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setFacture(facture2);
        ligneFacture2.setArticle(article2);
        ligneFacture2.setQuantite(1);
        em.persist(ligneFacture2);
        
        Client client3  = new Client();
        client3.setNom("Davis");
        client3.setPrenom("Miles");
        client3.setAge(60);
        client3.setCp(73100);
        client3.setCommune("Aix les Bains");
        em.persist(client3);

        Article article3 = new Article();
        article3.setLibelle("Trompette");
        article3.setPrix(2000.0);
        em.persist(article3);

        Facture facture3 = new Facture();
        facture3.setClient(client3);
        em.persist(facture3);

        LigneFacture ligneFacture3 = new LigneFacture();
        ligneFacture3.setFacture(facture3);
        ligneFacture3.setArticle(article3);
        ligneFacture3.setQuantite(1);
        em.persist(ligneFacture3);
        
        Client client4  = new Client();
        client4.setNom("Evans");
        client4.setPrenom("Bill");
        client4.setAge(45);
        client4.setCp(12000);
        client4.setCommune("Millau");
        em.persist(client4);

        Article article4 = new Article();
        article4.setLibelle("Piano");
        article4.setPrix(12000.0);
        em.persist(article4);

        Facture facture4 = new Facture();
        facture4.setClient(client4);
        em.persist(facture4);

        LigneFacture ligneFacture4 = new LigneFacture();
        ligneFacture4.setFacture(facture4);
        ligneFacture4.setArticle(article4);
        ligneFacture4.setQuantite(1);
        em.persist(ligneFacture4);
        
        Client client5  = new Client();
        client5.setNom("MCLAUGHLIN");
        client5.setPrenom("John");
        client5.setAge(70);
        client5.setCp(86000);
        client5.setCommune("Poitiers");
        em.persist(client5);

        Article article5 = new Article();
        article5.setLibelle("Citare");
        article5.setPrix(12000.0);
        em.persist(article5);

        Facture facture5 = new Facture();
        facture5.setClient(client5);
        em.persist(facture5);

        LigneFacture ligneFacture5 = new LigneFacture();
        ligneFacture5.setFacture(facture5);
        ligneFacture5.setArticle(article5);
        ligneFacture5.setQuantite(1);
        em.persist(ligneFacture5);
        
        Client client6  = new Client();
        client6.setNom("COODER");
        client6.setPrenom("Ry");
        client6.setAge(71);
        client6.setCp(12345);
        client6.setCommune("Los Angeles");
        em.persist(client6);

        Article article6 = new Article();
        article6.setLibelle("Bootle Neck");
        article6.setPrix(50.0);
        em.persist(article6);
		

        Facture facture6 = new Facture();
        facture6.setClient(client6);
        em.persist(facture6);

        LigneFacture ligneFacture6 = new LigneFacture();
        ligneFacture6.setFacture(facture6);
        ligneFacture6.setArticle(article6);
        ligneFacture6.setQuantite(5);
        em.persist(ligneFacture6);
       
    }
}
