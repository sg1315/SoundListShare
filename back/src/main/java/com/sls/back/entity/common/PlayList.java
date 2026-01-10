package com.sls.back.entity.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@Table(name = "PLAYLIST")
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYLIST_ID")
    private Long id;
    // 플레이리스트 고유번호 (PK)

    @Column(name = "TITLE", nullable = false)
    private String title;
    // 플레이리스트 제목

    @Column(name = "DESCRIPTION")
    private String description;
    // 플레이리스트 설명

    @Column(name = "IS_PUBLIC", nullable = false)
    private Boolean isPublic;
    // 공개 여부

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    // 생성일

    // ================= 연관관계 =================

    @OneToMany(
            mappedBy = "playlist",
            cascade = CascadeType.ALL, //플레이리스트 삭제시, 플레이리스트멤버에서 해당 멤버 데이터 자동 삭제
            orphanRemoval = true //플레이리스트에서 추방된 멤버는 PlaylistMember에서 자동삭제
    )
    private List<PlayListMember> members = new ArrayList<>();

    @OneToMany(
            mappedBy = "playlist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayListMusic> musics = new ArrayList<>();

    // ================= 연관관계 편의 메서드 =================

    public void addMember(PlayListMember member) {
        members.add(member);
        member.setPlaylist(this);
    }

    public void removeMember(PlayListMember member) {
        members.remove(member);
        member.setPlaylist(null);
    }

    public void addMusic(PlayListMusic playListMusic) {
        musics.add(playListMusic);
        playListMusic.setPlaylist(this);
    }

    public void removeMusic(PlayListMusic playListMusic) {
        musics.remove(playListMusic);
        playListMusic.setPlaylist(null);
    }


}
