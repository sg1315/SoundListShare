package com.sls.back.entity.common;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "ARTIST")
public class Artist {

    @Id
    @Column(name = "spotify_artist_id")
    private String spotifyArtistId;
    // 스포티파이 api_artist 고유키

    @Column(name = "artist_name")
    private String artistName;
    // 가수명

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MusicArtist> musicArtists = new ArrayList<>();

    public Artist(String spotifyArtistId, String artistName) {
        this.spotifyArtistId = spotifyArtistId;
        this.artistName = artistName;
    }

    /* 연관관계 편의 메서드 */
    public void addMusicArtist(MusicArtist musicArtist) {
        musicArtists.add(musicArtist);
        musicArtist.setArtist(this);
    }

    public void removeMusicArtist(MusicArtist musicArtist) {
        musicArtists.remove(musicArtist);
        musicArtist.setArtist(null);
    }
}
