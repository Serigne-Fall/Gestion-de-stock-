package com.engires.engigs;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

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
		for(int i=0;i<100;i++) {
		Produit prod=new Produit("Iphone "+i, 20000.0+1000, new Date(),9+2);
		produitRepository.save(prod);}
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

}
