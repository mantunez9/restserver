package isdcm.restserver.controller;

import isdcm.restserver.domain.ResultActionsCRUD;
import isdcm.restserver.dto.VideoDTO;
import isdcm.restserver.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/video")
public class VideoController {


    private final VideoService videoService;

    public VideoController(VideoService videoService) {this.videoService = videoService;}

    @PutMapping()
    public ResponseEntity<String> updateReproductions(@RequestBody VideoDTO videoDTO) {

        ResultActionsCRUD result = videoService.updateVideo(videoDTO.getId());

        if (result.isOk()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

}
