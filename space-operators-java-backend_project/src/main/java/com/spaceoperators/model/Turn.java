package com.spaceoperators.model;

import jakarta.persistence.*;

@Entity
public class Turn {

    @Id
    private String idTurn;
    private String number;
    private String role;
    private String duration;


    @ManyToOne
    @JoinColumn(name = "idGame", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "idTask", nullable = false)
    private Task task;

    public String getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(String idTurn) {
        this.idTurn = idTurn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


}

