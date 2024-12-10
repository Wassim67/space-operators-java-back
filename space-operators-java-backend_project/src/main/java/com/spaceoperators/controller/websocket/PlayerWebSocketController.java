package com.spaceoperators.controller.websocket;

import com.spaceoperators.dto.PlayerDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerWebSocketController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String handleHelloMessage(String message) throws Exception {
        // Traite le message reçu
        System.out.println("hello " + message);
        return "Hello, " + message + "!";
    }

    // Recevoir un message STOMP envoyé à /app/player
    @MessageMapping("/gs-guide-websocket")
    @SendTo("/topic/players")
    public PlayerDTO broadcastPlayerUpdate(PlayerDTO playerDTO) {
        System.out.println("player" + playerDTO);
        // Simuler une logique (ici, on transmet le DTO directement)
        return playerDTO; // Le message sera envoyé à tous les abonnés de /topic/players
    }
}
