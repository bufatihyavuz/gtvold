package com.gametopvideos.repository;

import com.gametopvideos.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface VideoDao extends CrudRepository<VideoEntity,Integer>,Serializable {
}
