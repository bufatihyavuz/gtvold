package com.gametopvideos.controller;

import com.gametopvideos.entity.VideoEntity;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(value = "/videos")
    public List<VideoEntity> VideoList(){
        List<VideoEntity> videoList = (List<VideoEntity>) videoService.findAll();
        return videoList;
        //return "Video List";
    }

    @GetMapping(value = "/hello")
    public String HelloWorld(){
        return "GameTopVideos";
    }

//    @GetMapping(value = "/videos2")
//    public List<VideoEntity> VideoList2(){
//        List<VideoEntity> videoList = (List<VideoEntity>) videoService.findAllByUserId(1);
//        return videoList;
//        //return "Video List";
//    }

    @GetMapping(value = "/videos3")
    public List<VideoEntity> findCities() {
        return (List<VideoEntity>) videoService.findAll();
    }


}
