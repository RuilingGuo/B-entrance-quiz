package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

    @GetMapping(path = "/teams")
    public List<StudentTeam> getTeamList(){
        return studentService.getStudentTeamList();
    }

    @PostMapping(path = "/teams")
    public List<StudentTeam> groupTeamList(){
        return studentService.groupStudentTeamList();
    }
}
