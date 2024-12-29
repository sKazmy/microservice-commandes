package com.example.microservicecommandes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    private Long id;
    private String description;
    private int quantite;
    private Date date;
    private double montant;
}
