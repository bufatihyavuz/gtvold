package com.gametopvideos.repository;

import com.gametopvideos.entity.Video;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface VideoRepository extends CrudRepository<Video,String> ,Serializable {
}
