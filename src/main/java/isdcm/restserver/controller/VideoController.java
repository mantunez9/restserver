package isdcm.restserver.controller;

import isdcm.restserver.dto.VideoDTO;
import isdcm.restserver.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {this.videoService = videoService;}

    @PutMapping()
    public ResponseEntity<VideoDTO> updateReproductions(@RequestBody Integer id) {
        Optional<VideoDTO> optionalVideoDTO = videoService.updateVideo(id);
        return optionalVideoDTO.map(dto -> ResponseEntity.ok().body(dto)).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
