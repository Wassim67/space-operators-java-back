package com.spaceoperators.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Task {
    @Id
    private int idTask;
    private String type;
    private String response;

    @OneToMany(mappedBy = "task")
    private Set<Turn> turns;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

}

