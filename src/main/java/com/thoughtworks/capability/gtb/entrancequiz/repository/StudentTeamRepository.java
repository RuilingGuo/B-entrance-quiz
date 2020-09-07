package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentTeamRepository {

    private static Integer BASE_TEAM_NUM = 6;
    private static Integer studentTeamIncId = 1;

    private List<StudentTeam> studentTeamList;

    public StudentTeamRepository(){
        this.studentTeamList = new ArrayList<>();
        initStudentTeamList();
    }

    public List<StudentTeam> findAll(){
        return this.studentTeamList;
    }

    public void save(List<StudentTeam> teamList){
        this.studentTeamList = teamList;
    }

    public static Integer getBaseTeamNum() {
        return BASE_TEAM_NUM;
    }

    private void initStudentTeamList() {
        for (int i = 0; i < BASE_TEAM_NUM; i++) {
            studentTeamList.add(new StudentTeam(studentTeamIncId++));
        }
    }

}
