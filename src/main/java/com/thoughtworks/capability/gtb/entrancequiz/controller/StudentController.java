package com.thoughtworks.capability.gtb.entrancequiz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @GetMapping(path = "/helloworld")
    public String helloworld(){
        return "helloworld";
    }
}
