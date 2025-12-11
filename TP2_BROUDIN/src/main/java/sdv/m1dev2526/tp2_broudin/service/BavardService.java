package sdv.m1dev2526.tp2_broudin.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BavardService {

    private String nom = "Nom ";

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String parler() {
        return nom + ":" + this.getClass().getSimpleName();

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("quelque chose");
    }
}
