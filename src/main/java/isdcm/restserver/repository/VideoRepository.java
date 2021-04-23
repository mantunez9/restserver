package isdcm.restserver.repository;

import isdcm.restserver.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    Optional<Video> findVideoByVideoId(@Param("video_id") Integer id);
}
