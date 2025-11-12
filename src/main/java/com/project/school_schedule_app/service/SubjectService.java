package com.project.school_schedule_app.service;

import com.project.school_schedule_app.dto.SubjectFormDto;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.repository.SubjectRepository;
import com.project.school_schedule_app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject createNewTeacher(SubjectFormDto dto){
        Subject subject = new Subject();
        Teacher teacher = teacherRepository.findById(dto.teacherId()).orElse(null);;

        subject.setName(dto.name());
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }


}
