package com.sls.back.api.music.service;

import com.sls.back.entity.common.Music;

public interface MusicService {
    Music getMusic(String trackId);
}
