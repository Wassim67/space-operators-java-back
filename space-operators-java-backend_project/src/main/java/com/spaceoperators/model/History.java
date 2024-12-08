package com.spaceoperators.model;

import jakarta.persistence.*;

@Entity
public class History {
    @Id
    private String idHistory;
    private String resultGame;
    private String turnsPlayed;
    @OneToOne(mappedBy = "history")
    private Game game;

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getResultGame() {
        return resultGame;
    }

    public void setResultGame(String resultGame) {
        this.resultGame = resultGame;
    }

    public String getTurnsPlayed() {
        return turnsPlayed;
    }

    public void setTurnsPlayed(String turnsPlayed) {
        this.turnsPlayed = turnsPlayed;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
