package com.spaceoperators.mapper;

import com.spaceoperators.dto.PlayerDTO;
import com.spaceoperators.model.Player;

import java.util.UUID;

public class PlayerMapper {

    // Convertir l'entité Player en PlayerDTO
    public static PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        // Conversion de UUID en String pour le DTO si nécessaire
        dto.setIdPlayer(player.getIdPlayer().toString()); // Conversion en String
        dto.setName(player.getName());
        dto.setEmail(player.getEmail());
        return dto;
    }

    // Convertir le PlayerDTO en entité Player
    public static Player toEntity(PlayerDTO dto) {
        Player player = new Player();

        // Vérifier si l'ID du player est présent dans le DTO
        if (dto.getIdPlayer() != null && !dto.getIdPlayer().isEmpty()) {
            UUID playerId = UUID.fromString(dto.getIdPlayer()); // Conversion en UUID
            player.setIdPlayer(playerId);
        } else {
            // Générer un nouvel ID si l'ID est manquant ou mal formaté
            player.setIdPlayer(UUID.randomUUID());
        }

        // Vérification si le nom est non nul avant de le définir
        if (dto.getName() != null) {
            player.setName(dto.getName());
        } else {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas être nul");
        }

        player.setEmail(dto.getEmail());
        return player;
    }

}
