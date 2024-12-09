package com.spaceoperators.repository;

import com.spaceoperators.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    // on peut faire des requetes specifique ici
    Player findByEmail(String email);
}
