package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.pojo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.pojo.StudentTeam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentTeamRepository {

    private static Integer BASE_TEAM_NUM = 6;
    private static Integer studentTeamIncId = 1;

    private List<StudentTeam> studentTeamList;

    public StudentTeamRepository(){
        initStudentTeamList();
    }

    public List<StudentTeam> findAll(){
        List<StudentTeam> copyList = new ArrayList<>(Arrays.asList(new StudentTeam[studentTeamList.size()]));
        Collections.copy(copyList, studentTeamList);
        return copyList;
    }

    public void save(List<StudentTeam> teamList){
        this.studentTeamList = teamList;
    }

    public static Integer getBaseTeamNum() {
        return BASE_TEAM_NUM;
    }

    private void initStudentTeamList() {
        this.studentTeamList =  new ArrayList<>();
        for (int i = 0; i < BASE_TEAM_NUM; i++) {
            studentTeamList.add(new StudentTeam(studentTeamIncId++,i+1));
        }
    }

    public List<StudentTeam> getNewTeamList() {
        resetStudentTeamMember();
        return this.studentTeamList;
    }

    private void resetStudentTeamMember() {
        this.studentTeamList.forEach(team -> {
            team.setStudentList(new ArrayList<>());
        });
    }
}
