package com.spaceoperators.controller;

import com.spaceoperators.dto.PlayerDTO;
import com.spaceoperators.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayer(@PathVariable String id) {
        logger.info("Received request to get player with ID: {}", id);

        PlayerDTO playerDTO = null;
        try {
            // Convertir l'ID de String à UUID
            UUID playerId = UUID.fromString(id);
            playerDTO = playerService.getPlayerById(playerId);

            if (playerDTO == null) {
                logger.warn("Player with ID {} not found", id);
            } else {
                logger.info("Player with ID {} found", id);
            }
        } catch (IllegalArgumentException e) {
            logger.error("Invalid UUID format for ID: {}", id);
        }

        return playerDTO;
    }


    @PostMapping("/")
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO) {
        logger.info("Received request to create player with name: {} and email: {}", playerDTO.getName(), playerDTO.getEmail());

        try {
            PlayerDTO createdPlayer = playerService.createPlayer(playerDTO);
            logger.info("Player with name: {} created successfully", createdPlayer.getName());
            return createdPlayer;
        } catch (Exception e) {
            logger.error("Error creating player with name: {}", playerDTO.getName(), e);
            throw e;
        }
    }
}
