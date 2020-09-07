package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.request.StudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "/student")
    public ResponseEntity addStudent(@RequestBody StudentRequest student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("成功添加");
    }
}
