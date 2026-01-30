package com.sls.back.entity.common;

import com.sls.back.enums.ArtistRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Column(name = "ROLE", nullable = false)
    private ArtistRole role;
    // MAIN, FEAT, PRODUCER

    // ================= 연관관계 =================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARITIST_ID", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_ID", nullable = false)
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

