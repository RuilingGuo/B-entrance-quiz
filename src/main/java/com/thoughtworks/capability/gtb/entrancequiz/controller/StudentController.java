package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }
}
