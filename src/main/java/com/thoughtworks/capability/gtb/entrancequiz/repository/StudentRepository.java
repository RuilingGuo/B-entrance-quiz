package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepository {
    private static Integer studentIncId =1;
    private List<Student> studentList;


    public StudentRepository() {
        this.studentList = new ArrayList<>();
        initStudentList();
    }

    public List<Student> findAll() {
        List<Student> copyList = new ArrayList<>(Arrays.asList(new Student[studentList.size()]));
        Collections.copy(copyList, studentList);
        return copyList;
    }

    public void addNewStudent(String studentName) {
        this.studentList.add(new Student(studentIncId++, studentName));
    }


    private void initStudentList() {
        addNewStudent("沈乐棋");
        addNewStudent("徐慧慧");
        addNewStudent("陈思聪");
        addNewStudent("王江林");
        addNewStudent("王登宇");
        addNewStudent("杨思雨");
        addNewStudent("江雨舟");
        addNewStudent("廖燊");
        addNewStudent("胡晓");
        addNewStudent("但杰");
        addNewStudent("盖迈达");
        addNewStudent("肖美琦");
        addNewStudent("黄云洁");
        addNewStudent("齐瑾浩");
        addNewStudent("刘亮亮");
        addNewStudent("肖逸凡");
        addNewStudent("王作文");
        addNewStudent("郭瑞凌");
        addNewStudent("李明豪");
        addNewStudent("党泽");
        addNewStudent("肖伊佐");
        addNewStudent("贠晨曦");
        addNewStudent("李康宁");
        addNewStudent("马庆");
        addNewStudent("商婕");
        addNewStudent("余榕");
        addNewStudent("谌哲");
        addNewStudent("董翔锐");
        addNewStudent("陈泰宇");
        addNewStudent("赵允齐");
        addNewStudent("张柯");
        addNewStudent("廖文强");
        addNewStudent("刘轲");
        addNewStudent("廖浚斌");
        addNewStudent("凌凤仪");
    }
}

