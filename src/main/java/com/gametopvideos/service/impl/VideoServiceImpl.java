package com.gametopvideos.service.impl;

import com.gametopvideos.entity.VideoEntity;
import com.gametopvideos.repository.VideoDao;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    public List<VideoEntity> findAll() {
        List<VideoEntity> cities = (List<VideoEntity>) videoDao.findAll();
        return cities;
    }

}
