package com.spaceoperators.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Session {
    @Id
    private UUID id;  // UUID comme clé primaire pour la session

    @ManyToOne
    @JoinColumn(name = "idPlayer", referencedColumnName = "idPlayer")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "idGame", referencedColumnName = "idGame")
    private Game game;

    // Constructeur sans argument
    public Session() {
        this.id = UUID.randomUUID();  // Génération d'un UUID unique pour la session
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
