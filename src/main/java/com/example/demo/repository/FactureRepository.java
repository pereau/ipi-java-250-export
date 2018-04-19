package com.example.demo.repository;

import com.example.demo.entity.Facture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	//@Query("SELECT f FROM Facture f WHERE f.client.id = :id")
	List<Facture> findByClientId(Long clientId); 
}
