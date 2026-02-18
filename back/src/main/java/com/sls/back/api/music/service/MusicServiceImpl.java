package com.sls.back.api.music.service;

import com.neovisionaries.i18n.CountryCode;
import com.sls.back.entity.common.Music;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService{

    private final SpotifyApi spotifyApi;

    //예시곡 Attention-찰리푸스
    //5cF0dROlMOK5uNZtivgu50?si=9d2585d36c7a405c
    //예시곡 Attention-뉴진스
    //2pIUpMhHL6L9Z5lnKxJJr9?si=9e14cf65378a4c4c


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
    public List<Music> searchMusics(String q) {
        try {
            spotifyApi.setAccessToken(getAccessToken());

            SearchTracksRequest searchRequest = spotifyApi.searchTracks(q)
                    .market(CountryCode.KR)
                    .limit(10)
                    .build();

            Paging<Track> searchPaging = searchRequest.execute();
            Track[] tracks = searchPaging.getItems();

            System.out.println("=== '" + q + "' 검색 결과 리스트 ===");

            if (tracks == null || tracks.length == 0) {
                System.out.println("검색 결과가 없습니다.");
            } else {
                for (int i = 0; i < tracks.length; i++) {
                    Track track = tracks[i];

                    // 아티스트가 여러 명일 수 있으므로 첫 번째 아티스트를 가져오거나 join으로 합칩니다.
                    String artistName = track.getArtists()[0].getName();
                    String albumName = track.getAlbum().getName();
                    String trackId = track.getId();

                    System.out.printf("[%d] ID: %s | 곡: %s | 아티스트: %s | 앨범: %s%n",
                            i + 1, trackId, track.getName(), artistName, albumName);
                }
            }

            System.out.println("======================================");

            return null;
        } catch (Exception e) {
            throw new RuntimeException("검색 실패: " + e.getMessage());
        }
    }

    @Override
    public Music getMusic(String trackId) {
        try {
            spotifyApi.setAccessToken(getAccessToken());

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
