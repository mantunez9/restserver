package isdcm.restserver.service;

import isdcm.restserver.domain.Video;
import isdcm.restserver.dto.VideoDTO;
import isdcm.restserver.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {this.videoRepository = videoRepository;}

    @Override
    public Optional<VideoDTO> updateVideo(Integer id) {

        Optional<Video> optionalVideo = videoRepository.findVideoByVideoId(id);

        if (optionalVideo.isPresent()) {

            Video video = optionalVideo.get();

            int plus = video.getReproduction() + 1;
            video.setReproduction(plus);

            videoRepository.saveAndFlush(video);

            return Optional.ofNullable(
                    VideoDTO.builder()
                            .id(video.getVideoId())
                            .reproductions(video.getReproduction())
                            .build()
            );

        }

        return Optional.empty();

    }
}
