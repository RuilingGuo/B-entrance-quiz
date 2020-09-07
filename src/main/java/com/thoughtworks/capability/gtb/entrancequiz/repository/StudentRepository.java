package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;


    public StudentRepository(){
        this.studentList = new ArrayList<>();

        initStudentList(this.studentList);
    }

    private void initStudentList(List<Student> studentList) {
        studentList.add(Student.builder()
                .id(1)
                .name("student")
                .build());
    }

    public List<Student> findAllStudents() {
        return this.studentList;
    }
}

