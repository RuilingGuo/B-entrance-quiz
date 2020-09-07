package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentTeamRepository studentTeamRepository;

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public List<StudentTeam> getStudentTeamList() {
        return studentsGroupByTeamNum();
    }

    private List<StudentTeam> studentsGroupByTeamNum() {
        int teamIndex = 0 ;
        int randomStudentIndex = 0;
        Random random = new Random();
        List<Student> studentList =  studentRepository.findAll();
        List<StudentTeam> teamList = studentTeamRepository.findAll();
        int iterationNum = studentList.size();
        for(int i = 0 ; i< iterationNum ;i++){
            randomStudentIndex = random.nextInt(studentList.size());
            teamList.get(teamIndex).addStudent(studentList.get(randomStudentIndex));
            studentList.remove(randomStudentIndex);
            teamIndex++;
            if(teamIndex==StudentTeamRepository.getBaseTeamNum()){
                teamIndex = 0;
            }
        }
        studentTeamRepository.save(teamList);
        return studentTeamRepository.findAll();
    }



}
