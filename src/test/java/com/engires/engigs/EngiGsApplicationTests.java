package com.engires.engigs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.engires.engigs.entities.Categorie;
import com.engires.engigs.entities.Produit;
import com.engires.engigs.repositorie.ProduitRepository;
import com.engires.engigs.service.ProduitServiceImpl;



@SpringBootTest
class EngiGsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private ProduitServiceImpl produitServiceImpl;
	
	@Test
	void TestcreateProduit() {
		Produit prod=new Produit("Iphone 222", 20000.0, new Date(),2);
		produitRepository.save(prod);
	}
	@Test
	void TestchercheProdById() {
		Produit p=produitRepository.findById(1L).get();
		System.out.println(p);
	}
	@Test
	void TestUpdate() {
		Produit p=produitRepository.findById(21L).get();
		p.setNomProduit("Iphone 13");
		produitRepository.save(p);
	}
	@Test
	void TestDeleteProduit() {
		produitRepository.deleteById(1L);
		System.out.println("suppression reussie");
	}
	
	@Test
	void getAllProduitParpage() {
		Page<Produit> produitsParPage=produitServiceImpl.getAllproduitsParPage(0, 2);
		System.out.println(produitsParPage.getTotalElements());
		System.out.println(produitsParPage.getSize());
		System.out.println(produitsParPage.getTotalPages());
		produitsParPage.getContent().forEach(p->{System.out.println(p.toString());});
	}
	@Test
	void testFindproduitByName() {
		List<Produit> prods=produitRepository.findByNomProduit("iphone 5");
		
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	@Test
	void testFindByMotcle() {
		List<Produit> prods=produitRepository.findByNomProduitContains("ip");
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	@Test
	void testFindbyNamePrixAVCJPQL() {
		List<Produit> prods=produitRepository.findByNomPrix("iphone 5", 21000.0);
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	@Test
	void testFindbyNCategorieAVCJPQL() {
		Categorie cat =new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods=produitRepository.findByCategorie(cat);
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	@Test
	void testFindbyCategorie() {
		
		List<Produit> prods=produitRepository.findByCategorieIdCat(1L);
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	@Test
	void testFindbyOderByNomProduit() {
		
		List<Produit> prods=produitRepository.findByOrderByNomProduitAsc();
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	
	@Test
	void testFindbyOderByNomProduitAscAndPrixDesc() {
		
		List<Produit> prods=produitRepository.trierByOrderAcsNomAndPrixDesc();
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
}
