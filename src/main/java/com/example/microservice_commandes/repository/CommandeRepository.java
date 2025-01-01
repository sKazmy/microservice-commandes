package com.example.microservice_commandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.microservice_commandes.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Add custom query methods if needed
}