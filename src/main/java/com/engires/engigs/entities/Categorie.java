package com.engires.engigs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	@OneToMany(mappedBy = "categorie")
	List<Produit> produits;
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Categorie(String nomCat, String descriptionCat) {
		super();
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
	}


	public Long getIdCat() {
		return idCat;
	}


	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}


	public String getNomCat() {
		return nomCat;
	}


	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}


	public String getDescriptionCat() {
		return descriptionCat;
	}


	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}


	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + ", descriptionCat=" + descriptionCat + ", produits="
				+ produits + "]";
	}
	
	
	
	
}
