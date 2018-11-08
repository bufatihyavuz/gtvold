package com.gametopvideos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametopvideos.entity.VideoEntity;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
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

    @GetMapping(value = "/helloJsp")
    public ModelAndView deneme() {
        ModelAndView modelAndView2 = new ModelAndView();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("date",new Date());
        return modelAndView;
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
    public String addVideo(@RequestBody String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        VideoEntity videoEntity  = objectMapper.readValue(json, VideoEntity.class);
        videoService.save(videoEntity);
        return "succes";
    }

    @DeleteMapping(value = "/videos/{id}")
    public String deleteVideo(@PathVariable Integer id){
        videoService.deleteById(id);
            return "success";
        }
}
