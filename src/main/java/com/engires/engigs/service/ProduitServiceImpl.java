package com.engires.engigs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.engires.engigs.entities.Categorie;
import com.engires.engigs.entities.Produit;
import com.engires.engigs.repositorie.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository produitRepository;
	@Override
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
	}

	@Override
	public Produit getProduitById(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Page<Produit> getAllproduitsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return produitRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findBynomProduitConatins(String mot_cle) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomProduitContains(mot_cle);
	}

	@Override
	public List<Produit> findbyCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		// TODO Auto-generated method stub
		return findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findbyNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> trierByNomAscAndPrixDes() {
		// TODO Auto-generated method stub
		return produitRepository.trierByOrderAcsNomAndPrixDesc();
	}

}
