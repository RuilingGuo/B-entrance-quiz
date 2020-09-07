package com.thoughtworks.capability.gtb.entrancequiz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentTeam {
    private Integer id;
    private String name;
    private List<Student> studentList;

    public StudentTeam(Integer id,Integer teamIndex) {
        this.id = id;
        this.name ="Team "+teamIndex;
        this.studentList = new ArrayList<>();
    }

    public void addTeamStudents(List<Student> studentList){
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }
}
