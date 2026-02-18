package com.sls.back.api.music.controller;

import com.sls.back.api.music.service.MusicService;
import com.sls.back.entity.common.Music;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/spotify")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/search")
    public ResponseEntity<List<Music>> searchMusics(@RequestParam String q){
        System.out.println("컨트롤러 진입");
        List<Music> results = musicService.searchMusics(q);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<Music> getMusic(@PathVariable String id) {
        System.out.println("컨트롤러 진입");
        return ResponseEntity.ok(musicService.getMusic(id));
    }

}
