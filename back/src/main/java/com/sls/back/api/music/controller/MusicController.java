package com.sls.back.api.music.controller;

import com.sls.back.api.music.service.MusicService;
import com.sls.back.entity.common.Music;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/search")
    public ResponseEntity<List<Music>> searchMusic(String keyword) {
        System.out.println(">>> 컨트롤러 진입 성공!");
        keyword = "attension";
        return ResponseEntity.ok(musicService.searchMusic(keyword));
    }

}
