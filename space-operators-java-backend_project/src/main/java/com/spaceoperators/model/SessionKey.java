package com.spaceoperators.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessionKey implements Serializable {
    private String idPlayer;
    private String idGame;

    // Constructeurs, hashCode, equals, Getters et setters
}

