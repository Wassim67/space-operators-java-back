package com.spaceoperators.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Game {
    @Id
    private String idGame;
    private String name;
    private String state;
    private String choiceTheme;
    private int integrity;

    @OneToOne
    @JoinColumn(name = "idHistory", nullable = false)
    private History history;

    @OneToMany(mappedBy = "game")
    private Set<Turn> turns;

    @OneToMany(mappedBy = "game")
    private Set<Session> sessions;

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChoiceTheme() {
        return choiceTheme;
    }

    public void setChoiceTheme(String choiceTheme) {
        this.choiceTheme = choiceTheme;
    }

    public int getIntegrity() {
        return integrity;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }
}
