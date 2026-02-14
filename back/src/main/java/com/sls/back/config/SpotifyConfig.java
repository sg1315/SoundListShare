package com.sls.back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.michaelthelin.spotify.SpotifyApi;

@Configuration
public class SpotifyConfig {

    @Value("${spotify.api.client-id}") String clientId;
    @Value("${spotify.api.client-secret}") String clientSecret;

    @Bean
    public SpotifyApi spotifyApi() {
        return new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
    }
}
