package com.sls.back.api.music.service;

import com.sls.back.entity.common.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService{

    private final SpotifyApi spotifyApi;


    public String getAccessToken() {
        try {
            ClientCredentialsRequest request = spotifyApi.clientCredentials().build();
            ClientCredentials credentials = request.execute();
            return credentials.getAccessToken();
        } catch (Exception e) {
            throw new RuntimeException("토큰 발급 실패: " + e.getMessage());
        }
    }

    @Override
    public Music getMusic(String trackId) {
        try {
            String token = getAccessToken();
            spotifyApi.setAccessToken(token);

            //예시곡 Attention-찰리푸스
            //5cF0dROlMOK5uNZtivgu50?si=9d2585d36c7a405c

            //예시곡 Attention-뉴진스
            //2pIUpMhHL6L9Z5lnKxJJr9?si=9e14cf65378a4c4c

            GetTrackRequest getTrackRequest = spotifyApi.getTrack(trackId).build();
            Track track = getTrackRequest.execute();


            // 3. 데이터 콘솔 출력 (확인용)
            System.out.println("=== Spotify Metadata 확인 ===");
            System.out.println("곡 제목: " + track.getName());
            System.out.println("아티스트: " + track.getArtists()[0].getName());
            System.out.println("앨범명: " + track.getAlbum().getName());
            System.out.println("앨범 발매일: " + track.getAlbum().getReleaseDate());
            System.out.println("앨범 커버 URL: " + track.getAlbum().getImages()[0].getUrl());
            System.out.println("재생 시간(ms): " + track.getDurationMs());
            System.out.println("인기도: " + track.getPopularity());
            System.out.println("============================");

            return null;
        } catch (Exception e) {
            throw new RuntimeException("메타데이터 조회 실패: " + e.getMessage());
        }
    }
}
