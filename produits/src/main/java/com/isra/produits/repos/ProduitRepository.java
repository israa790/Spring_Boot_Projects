package com.isra.produits.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.isra.produits.entities.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}