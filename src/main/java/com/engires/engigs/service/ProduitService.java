package com.engires.engigs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.engires.engigs.entities.Categorie;
import com.engires.engigs.entities.Produit;



public interface ProduitService {
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduitById(Long id);
	List<Produit> getAllProduits();
	
	Page<Produit> getAllproduitsParPage(int page,int size);
	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findBynomProduitConatins(String mot_cle);
	List<Produit> findbyCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	
	//jpql
	List<Produit> findByCategorie(Categorie categorie);
	List<Produit> findbyNomPrix(String nom,Double prix);
	List<Produit> trierByNomAscAndPrixDes();
}
