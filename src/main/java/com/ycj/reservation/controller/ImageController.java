package com.ycj.reservation.controller;

import com.ycj.reservation.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("files") MultipartFile[] files, @AuthenticationPrincipal Principal principal,@RequestParam("range") int range,@RequestParam("actID") String actID){
        if(principal == null){
            return "{\"username\":\"null\"}";
        }
        imageService.uploadImages(files,principal.getName(),range,actID);
        return null;
    }
}
