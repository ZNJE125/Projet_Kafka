package com.API.GED.Kafka.Modeles;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ConcurrentHashMap;


public class Document {

    public Document(Integer identifiant, String nom, Type type, String contenu) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.type = type;
        this.contenu = contenu;
    }

    private Integer identifiant;

    private String nom;
    private Type type;
private String contenu;

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
