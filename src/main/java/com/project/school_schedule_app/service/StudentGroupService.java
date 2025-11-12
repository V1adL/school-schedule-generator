package com.project.school_schedule_app.service;

import com.project.school_schedule_app.dto.StudentGroupFormDto;
import com.project.school_schedule_app.model.StudentGroup;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    public List<StudentGroup> getAllStudentsGroup(){
        return studentGroupRepository.findAll();
    }

    public StudentGroup createNewStudentGroup(StudentGroupFormDto dto){
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setName(dto.name());
        studentGroup.setStudentCount(dto.studentCount());

        return studentGroupRepository.save(studentGroup);
    }
}
