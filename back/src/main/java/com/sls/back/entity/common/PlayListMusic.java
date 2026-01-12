package com.sls.back.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "PLAYLIST_MUSIC")
public class PlayListMusic {
    //플레이리스트-음악 중계 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    // 중계 테이블 PK


    @Column(name = "SPOTIFY_ARTIST_ID")
    private String spotifyArtistId;
    // 대표 아티스트 ID

    @Column(name = "ORDER_NO", nullable = false)
    private Long orderNo;
    // 플레이리스트 내 순서

    @Column(name = "ADDED_AT")
    private LocalDateTime addedAt;
    // 추가 날짜

    // ================= 연관관계 =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYLIST_ID", nullable = false)
    private PlayList playlist;
    // 플레이리스트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOTIFY_MUSIC_ID", nullable = false)
    private Music music;
    // 음악

    // ================= 강제 생성자 =================
    public PlayListMusic(PlayList playlist, Music music, Long orderNo) {
        this.playlist = playlist;
        this.music = music;
        this.orderNo = orderNo;
    }


    // ================= 연관관계 내부 제어 =================
    void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }

    public void changeOrder(Long orderNo) {
        this.orderNo = orderNo;
    }
}
