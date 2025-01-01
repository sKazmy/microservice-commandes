package com.example.microservice_commandes.health;

import com.example.microservice_commandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeService commandeService;

    @Override
    public Health health() {
        if (commandeService.countCommandes() > 0) {
            return Health.up().withDetail("status", "UP").build();
        } else {
            return Health.down().withDetail("status", "DOWN").build();
        }
    }
}