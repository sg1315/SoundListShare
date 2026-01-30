package com.sls.back.config;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@RequiredArgsConstructor
public class SoundCloudConfig {

    @Value("${soundcloud.api.client-id}")
    private String clientId;

    @Bean
    public WebClient soundCloudWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.soundcloud.com")
                .filter((request, next) -> {
                    URI uri = UriComponentsBuilder.fromUri(request.url())
                            .queryParam("client_id", clientId)
                            .build(true)
                            .toUri();

                    ClientRequest newRequest = ClientRequest.create(request.method(), uri)
                            .headers(headers -> headers.addAll(request.headers()))
                            .cookies(cookies -> cookies.addAll(request.cookies()))
                            .attributes(attributes -> attributes.putAll(request.attributes()))
                            .body(request.body())
                            .build();

                    return next.exchange(newRequest);
                })
                .build();
    }
}
