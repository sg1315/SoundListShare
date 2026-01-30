package com.sls.back.api.music.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sls.back.api.music.repository.MusicRepository;
import com.sls.back.entity.common.Music;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService{

    private final WebClient soundCloudWebClient;
    private final MusicRepository musicRepository;

    @Value("${soundcloud.api.client-id}")
    private String clientId;

    @Value("${soundcloud.api.client-secret}")
    private String clientSecret;

    @Override
    public List<Music> searchMusic(String keyword) {
        // 1. Access Token 발급
        String accessToken = soundCloudWebClient.post()
                .uri("https://api.soundcloud.com/oauth2/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("grant_type", "client_credentials"))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(node -> node.get("access_token").asText())
                .block();
        System.out.println(">>> 발급된 토큰: " + accessToken);

        // 2. 토큰을 헤더에 담아 검색 요청
        return soundCloudWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.soundcloud.com")
                        .path("/tracks")
                        .queryParam("q", keyword)
                        .build())
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToFlux(Music.class)
                .collectList()
                .block();
    }



//    public List<Music> searchMusic(String keyword) {
//        //입력받은 키워드(제목)를 통해 soundCloud에서 그 키워드와 일치하는 음악 찾기
//        List<MusicDto.SaveMusic> dtos = soundCloudWebClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/tracks")
//                        .queryParam("q", keyword)
//                        .queryParam("client_id", clientId)
//                        .build())
//                .retrieve()
//                .bodyToFlux(MusicDto.SaveMusic.class)
//                .collectList()
//                .block();
//
//        if (dtos != null && !dtos.isEmpty()) {
//            System.out.println("\n>>> 사운드클라우드 API 수신 데이터 확인");
//            dtos.forEach(dto ->
//                    System.out.println("ID: " + dto.getSound_cloud_music_id() +
//                            " | 제목: " + dto.getTitle() +
//                            " | 길이: " + dto.getDuration() + "ms")
//            );
//            System.out.println(">>> 총 " + dtos.size() + "건 수신 완료\n");
//        } else {
//            System.out.println(">>> 수신된 데이터가 없습니다.");
//        }
//
//        if (dtos == null) return Collections.emptyList();
//
//        return null;
//    }
}
