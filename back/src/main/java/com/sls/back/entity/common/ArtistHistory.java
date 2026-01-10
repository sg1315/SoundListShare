package com.sls.back.entity.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "ARTIST_HISTORY")
public class ArtistHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    // 가수 재생 기록 고유번호 (PK)

    @Column(name = "PLAY_COUNT", nullable = false)
    private Long playCount;
    // 해당 가수 재생 횟수

    // ================= 연관관계 =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOTIFY_ARTIST_ID", nullable = false)
    private Artist artist;
    // Artist 테이블과 연결(스포티파이 api_artist 고유키와 스포티파이 api_track 고유키를 가져올 수 있음)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    // 사용자

    // ================= 강제 생성자 =================
    public ArtistHistory(User user, Artist artist) {
        this.user = user;
        this.artist = artist;
        this.playCount = 0L;
    }

    // ================= 비즈니스 메서드 =================

    public void increasePlayCount() {
        this.playCount++; //조회수 증가
    }
}
