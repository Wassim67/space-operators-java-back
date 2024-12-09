package com.spaceoperators.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Player {
    @Id
    private String idPlayer;

    private String name;
    private String pwd;
    private String email;

    @OneToMany(mappedBy = "player")
    private Set<Session> sessions;

    // Constructeur sans argument
    public Player() {
        this.idPlayer = String.valueOf(UUID.randomUUID());  // Génération d'un UUID unique à chaque instantiation
    }

    // Getters and Setters
    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(UUID idPlayer) {
        this.idPlayer = String.valueOf(idPlayer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
