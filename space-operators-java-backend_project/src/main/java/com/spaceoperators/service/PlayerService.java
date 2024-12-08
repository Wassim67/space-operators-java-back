package com.spaceoperators.service;

import com.spaceoperators.dto.PlayerDTO;
import com.spaceoperators.mapper.PlayerMapper;
import com.spaceoperators.model.Player;
import com.spaceoperators.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDTO getPlayerById(UUID idPlayer) {
        Optional<Player> player = playerRepository.findById(idPlayer);
        return player.map(PlayerMapper::toDTO).orElse(null);
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        // Vérification des données du joueur
        if (playerDTO.getName() == null || playerDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas être nul ou vide");
        }

        if (playerDTO.getEmail() == null || playerDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("L'email du joueur ne peut pas être nul ou vide");
        }

        // Vérification que l'email est valide (simple validation d'email)
        if (!playerDTO.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            throw new IllegalArgumentException("L'email du joueur n'est pas valide");
        }

        // Conversion du DTO en entité
        Player player = PlayerMapper.toEntity(playerDTO);

        // Sauvegarde du joueur
        Player savedPlayer = playerRepository.save(player);

        // Retourner le DTO du joueur créé
        return PlayerMapper.toDTO(savedPlayer);
    }

}
