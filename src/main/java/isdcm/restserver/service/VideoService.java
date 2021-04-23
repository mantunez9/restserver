package isdcm.restserver.service;

import isdcm.restserver.dto.VideoDTO;

import java.util.Optional;

public interface VideoService {
    Optional<VideoDTO> updateVideo(Integer id);
}
