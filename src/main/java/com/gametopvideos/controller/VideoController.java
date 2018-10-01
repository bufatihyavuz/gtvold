package com.gametopvideos.controller;

import com.gametopvideos.entity.VideoEntity;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(value = "/hello")
    public String HelloWorld(){
        return "GameTopVideos";
    }

    @GetMapping(value = "/videos")
    public List<VideoEntity> getAllVideos() {
        return (List<VideoEntity>) videoService.findAll();
    }

    @GetMapping(value = "/videos/{id}")
    public Optional<VideoEntity> getVideo(@PathVariable Integer id){
        return videoService.findById(id);
    }

    @PostMapping(value = "/videos")
    public void addVideo(VideoEntity videoEntity){
        videoService.save(videoEntity);
    }
}
