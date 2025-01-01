package com.example.microservice_commandes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;

    // Explicitly define the getter methods
    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getMontant() {
        return montant;
    }

    // Explicitly define the setter methods
    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    // Explicitly define the setter method for date (if not already added)
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
