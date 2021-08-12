package com.engires.engigs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.engires.engigs.entities.Produit;



public interface ProduitService {
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduitById(Long id);
	List<Produit> getAllProduits();
	
	Page<Produit> getAllproduitsParPage(int page,int size);
}
