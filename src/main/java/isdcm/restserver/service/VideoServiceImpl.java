package isdcm.restserver.service;

import isdcm.restserver.domain.ResultActionsCRUD;
import isdcm.restserver.domain.Video;
import isdcm.restserver.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {this.videoRepository = videoRepository;}

    @Override
    public ResultActionsCRUD updateVideo(Integer id) {

        Optional<Video> optionalVideo = videoRepository.findVideoByVideoId(id);

        if (optionalVideo.isPresent()) {

            Video video = optionalVideo.get();

            int plus = video.getReproduction() + 1;
            video.setReproduction(plus);

            videoRepository.saveAndFlush(video);

            return ResultActionsCRUD
                    .builder()
                    .isOk(true)
                    .build();

        }

        return ResultActionsCRUD
                .builder()
                .isOk(false)
                .missatge("Video not found")
                .build();

    }
}
