package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Brokering messages to clients
        config.setApplicationDestinationPrefixes("/app"); // Prefix for messages sent from clients
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket") // WebSocket endpoint
                .setAllowedOrigins("http://127.0.0.1:5500") ;// Autorise toutes les origines
                //.withSockJS(); // Support SockJS pour compatibilité avec navigateurs anciens
        registry.addEndpoint("/gs-guide-websocket") // WebSocket endpoint
                .setAllowedOrigins("http://127.0.0.1:5500")// Autorise toutes les origines
                .withSockJS(); // Support SockJS pour compatibilité avec navigateurs anciens
    }
}