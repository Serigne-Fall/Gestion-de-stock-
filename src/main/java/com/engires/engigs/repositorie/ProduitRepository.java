package com.engires.engigs.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.engires.engigs.entities.Categorie;
import com.engires.engigs.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByNomProduit(String nom);
	
	List<Produit> findByNomProduitContains(String mt_cle);
	
	
	List<Produit> findByCategorieIdCat(Long id);
	
	
	List<Produit> findByOrderByNomProduitAsc();
	
	
	@Query("select p from Produit p where p.nomProduit like %?1 AND p.prixProduit> ?2")
	List<Produit> findByNomPrix(String nom,Double prix);
	
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit= :prix")
	List<Produit> findByNomPrixAVCParam(@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Produit p where p.categorie=?1")
	List<Produit> findByCategorie(Categorie categorie);
	
	@Query("select p from Produit p order by p.nomProduit ASC , p.prixProduit DESC")
	List<Produit> trierByOrderAcsNomAndPrixDesc();
}
