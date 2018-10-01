package com.gametopvideos.service;

import com.gametopvideos.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface VideoService extends CrudRepository<VideoEntity,Integer>,Serializable {
    public List<VideoEntity> findAll();
}
