package com.engires.engigs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.engires.engigs.entities.Produit;
import com.engires.engigs.service.ProduitServiceImpl;



@Controller
public class ProduitController {
	
	@Autowired
	ProduitServiceImpl produitServiceImpl;
	@RequestMapping("/")
	public String index() {
		return "template";
	}
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createProduit";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("Produit") Produit produit,@RequestParam("date") String date,ModelMap modelMap) throws ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated=dateFormat.parse(date);
		produit.setDateCreated(dateCreated);
		Produit produitSave=produitServiceImpl.saveProduit(produit);
		String msg="Le produit a ete enregistre avec un id :"+produitSave.getIdProduit();
		modelMap.addAttribute("msg",msg);
		return "createProduit";
	}
	
	@RequestMapping("/listeProduits")
	public String showListeProduits(ModelMap modelMap,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
//		List<Produit> produits=produitServiceImpl.getAllProduits();
//		modelMap.addAttribute("produits",produits);
		Page<Produit> produitsParPage=produitServiceImpl.getAllproduitsParPage(page, size);
		modelMap.addAttribute("produits",produitsParPage);
		modelMap.addAttribute("nbrPages",new int[produitsParPage.getTotalPages()]);
		modelMap.addAttribute("currentPage",page);
		modelMap.addAttribute("size",size);
		return "listeProduits";
	}
	@RequestMapping("/deleteProduit")
	public String deleteProduit(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		produitServiceImpl.deleteProduitById(id);
		Page<Produit> produitsParPage=produitServiceImpl.getAllproduitsParPage(page, size);
		modelMap.addAttribute("produits",produitsParPage);
		modelMap.addAttribute("nbrPages",new int[produitsParPage.getTotalPages()]);
		modelMap.addAttribute("currentPage",page);
		modelMap.addAttribute("size",size);
		return "listeProduits";
	}
	@RequestMapping("/editProduitForm")
	public String editProduitForm(@RequestParam("id") Long id,ModelMap modelMap) {
		Produit produit=produitServiceImpl.getProduitById(id);
		modelMap.addAttribute("produit",produit);
		return "editForm";
	}
	@RequestMapping("/editProduit")
	public String editProduit(@ModelAttribute("Produit") Produit produit,@RequestParam("date") String date ,ModelMap modelMap,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated=format.parse(date);
		produit.setDateCreated(dateCreated);
		produitServiceImpl.updateProduit(produit);
		Page<Produit> produitsParPage=produitServiceImpl.getAllproduitsParPage(page, size);
		modelMap.addAttribute("produits",produitsParPage);
		modelMap.addAttribute("nbrPages",new int[produitsParPage.getTotalPages()]);
		modelMap.addAttribute("currentPage",page);
		modelMap.addAttribute("size",size);
		return "listeProduits";
	}
}
