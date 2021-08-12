package com.engires.engigs.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engires.engigs.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
