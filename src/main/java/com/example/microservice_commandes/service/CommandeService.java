package com.example.microservice_commandes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import com.example.microservice_commandes.model.Commande;
import com.example.microservice_commandes.repository.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Get all commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Create a new commande
    public Commande createCommande(Commande commande) {
        commande.setDate(LocalDate.now()); // Set current date
        return commandeRepository.save(commande);
    }

    // Get a commande by ID
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));
    }

    // Update an existing commande
    public Commande updateCommande(Long id, Commande updatedCommande) {
        Commande existingCommande = getCommandeById(id);
        existingCommande.setDescription(updatedCommande.getDescription());
        existingCommande.setQuantite(updatedCommande.getQuantite());
        existingCommande.setMontant(updatedCommande.getMontant());
        return commandeRepository.save(existingCommande);
    }

    // Delete a commande
    public void deleteCommande(Long id) {
        Commande existingCommande = getCommandeById(id);
        commandeRepository.delete(existingCommande);
    }

    // Count commandes for health check
    public long countCommandes() {
        return commandeRepository.count();
    }
}