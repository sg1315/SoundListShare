package com.sls.back.entity.common;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "MUSIC")
public class Music {
    // 음악

    @Id
    @Column(name = "ID")
    private Long Id;
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
