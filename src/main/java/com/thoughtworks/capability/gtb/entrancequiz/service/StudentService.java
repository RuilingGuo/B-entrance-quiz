package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.request.StudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.request.UpdateTeamRequest;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    public List<StudentTeam> groupStudentTeamList() {
        return studentsGroupByTeamNum();
    }

    private List<StudentTeam> studentsGroupByTeamNum() {
        int teamIndex = 0 ;
        int randomStudentIndex = 0;
        Random random = new Random();
        List<Student> studentList =  studentRepository.findAll();
        List<StudentTeam> teamList = studentTeamRepository.getNewTeamList();
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
        teamList.forEach(team -> team.getStudentList().sort(Comparator.comparingInt(Student::getId)));
        studentTeamRepository.save(teamList);
        return studentTeamRepository.findAll();
    }


    public List<StudentTeam> getStudentTeamList() {
        return studentTeamRepository.findAll();
    }

    public void addStudent(StudentRequest student) {
        studentRepository.addNewStudent(student.getStudentName());
    }

    public void updateTeamName(UpdateTeamRequest request) {
        studentTeamRepository.findAll().get(request.getTeamId()-1).setName(request.getTeamName());
    }
}
