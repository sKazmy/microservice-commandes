package com.example.microservice_commandes.controller;

import com.example.microservicecommandes.model.Commande;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private List<Commande> commandes = new ArrayList<>();
    private long currentId = 1;

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        commande.setId(currentId++);
        commandes.add(commande);
        return commande;
    }

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandes;
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande updatedCommande) {
        Commande commande = getCommandeById(id);
        if (commande != null) {
            commande.setDescription(updatedCommande.getDescription());
            commande.setQuantite(updatedCommande.getQuantite());
            commande.setDate(updatedCommande.getDate());
            commande.setMontant(updatedCommande.getMontant());
        }
        return commande;
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandes.removeIf(c -> c.getId().equals(id));
    }
}
