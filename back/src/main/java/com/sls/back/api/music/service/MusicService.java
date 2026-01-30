package com.sls.back.api.music.service;

import com.sls.back.entity.common.Music;
import java.util.List;

public interface MusicService {
    List<Music> searchMusic(String keyword);
}
