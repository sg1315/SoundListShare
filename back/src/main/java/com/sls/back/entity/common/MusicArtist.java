package com.sls.back.entity.common;

import com.sls.back.enums.ArtistRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "MUSIC_ARTIST")
public class MusicArtist {
    // 음악-가수 중계 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 고유 Id (PK)

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private ArtistRole role;
    // MAIN, FEAT, PRODUCER

    // ================= 연관관계 =================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spotify_artist_id", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spotify_music_id", nullable = false)
    private Music music;

    // ================= 강제 생성자 =================
    public MusicArtist(ArtistRole role, Music music, Artist artist) {
        this.role = role;
        this.music = music;
        this.artist = artist;
    }

    /* 연관관계 세터 (패키지/도메인 내부용) */
    void setArtist(Artist artist) {
        this.artist = artist;
    }

    void setMusic(Music music) {
        this.music = music;
    }
}

