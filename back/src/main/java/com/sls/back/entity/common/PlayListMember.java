package com.sls.back.entity.common;

import com.sls.back.enums.PlaylistRole;
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
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "PLAYLIST_MEMBER")
public class PlayListMember {
    // 플레이리스트 참여자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYLIST_USER_ID")
    private Long id;
    //기본키,사용자 고유번호(User테이블 사용자 고유번호랑 다름)

    // ================= 연관관계 =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID", nullable = false)
    private Users users;
    // 참여 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYLIST_ID", nullable = false)
    private PlayList playlist;
    // 참여한 플레이리스트

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private PlaylistRole role;
    // 플레이리스트 권한

    @Column(name = "JOINED_AT")
    private LocalDateTime joinedAt;
    // 참여 일자

    // ================= 강제 생성자 =================
    public PlayListMember(Users users, PlayList playlist, PlaylistRole role) {
        this.users = users;
        this.playlist = playlist;
        this.role = role;
    }

    //---------------------------------------------------------------------------------------------
    public void changeRole(PlaylistRole role) {
        this.role = role;
    }
    // 혹시나 역할을 바꿀 때

    void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }
}
