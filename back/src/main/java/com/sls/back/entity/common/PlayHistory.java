package com.sls.back.entity.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "PLAY_HISTORY")
public class PlayHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    // 재생 기록 고유번호 (PK)

    @Column(name = "PLAY_COUNT", nullable = false)
    private Long playCount;
    // 해당 곡 재생 횟수


    // ================= 연관관계 =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOTIFY_MUSIC_ID", nullable = false)
    private Music music;
    // Music과 연결(스포티파이 api_artist 고유키와 스포티파이 api_track 고유키를 가져올 수 있음)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    // 재생한 사용자

    // ================= 강제 생성자 =================
    public PlayHistory(User user, Music music) {
        this.user = user;
        this.music = music;
        this.playCount = 0L;
    }
    // 필수값 강제 생성자

    // ================= 비즈니스 메서드 =================

    public void increasePlayCount() {
        this.playCount++; //조회수 증가
    }
}
