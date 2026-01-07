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
@Table(name = "MUSIC")
public class Music {

    @Id
    @Column(name = "SPOTIFY_MUSIC_ID")
    private String spotifyMusicId;
    // 스포티파이 api_track 고유키

    @Column(name = "TITLE", nullable = false)
    private String title;
    // 곡명

    @Column(name = "DURATION")
    private Long duration;
    // 노래 길이

    @Column(name = "AUDIO_URL")
    private String audioUrl;
    // 음원

    // ================= 연관관계 =================
    @OneToMany(
            mappedBy = "music",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MusicArtist> musicArtists = new ArrayList<>();
}
