package com.sls.back.api.music.repository;

import com.sls.back.entity.common.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
//    Optional<Music> findBySoundCloudId(Long soundCloudId);
//
//    List<Music> findByTitleContaining(String title);
//
//    Optional<Music> save(MusicDto musicDto);

}
