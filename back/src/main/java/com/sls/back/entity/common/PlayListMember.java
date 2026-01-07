package com.sls.back.entity.common;

import com.sls.back.enums.PlaylistRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "PLAYLIST_MEMBER")
public class PlayListMember {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYLIST_USER_ID")
    private Long id;
    //기본키,사용자 고유번호(User테이블 사용자 고유번호랑 다름)

    //---------------------------------------------------------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
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
    public PlayListMember(User user, PlayList playlist, PlaylistRole role) {
        this.user = user;
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
