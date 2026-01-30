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
@Table(name = "ARTIST")
public class Artist {
    // 가수

    @Id
    @Column(name = "ID")
    private Long id;
    // 스포티파이 api_artist 고유키

    @Column(name = "ARTIST_NAME")
    private String artistName;
    // 가수명

    // ================= 연관관계 =================
    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MusicArtist> musicArtists = new ArrayList<>();

    // ================= 강제 생성자 =================
    public Artist(long apiId, String artistName) {
        this.id = apiId;
        this.artistName = artistName;
    }

    // ================= 비즈니스 메서드 =================
    public void addMusicArtist(MusicArtist musicArtist) {
        musicArtists.add(musicArtist);
        musicArtist.setArtist(this);
    }

    public void removeMusicArtist(MusicArtist musicArtist) {
        musicArtists.remove(musicArtist);
        musicArtist.setArtist(null);
    }
}
