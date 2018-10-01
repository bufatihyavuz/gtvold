package com.gametopvideos.service;

import com.gametopvideos.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface VideoService extends CrudRepository<VideoEntity,Integer>,Serializable {}
