package com.sls.back.api.music.dto;

import com.sls.back.entity.common.Music;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MusicDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SaveMusic {
        private Long sound_cloud_music_id; // 스포티파이 api_track 고유키
        private String title; // 곡명
        private Long duration; // 음원

        public Music toEntity(){
            return Music.builder()
                    .Id(sound_cloud_music_id)
                    .title(title)
                    .duration(duration)
                    .build();
        }

    }
}
