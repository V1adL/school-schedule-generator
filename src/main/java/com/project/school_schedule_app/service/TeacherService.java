package com.project.school_schedule_app.service;

import com.project.school_schedule_app.dto.TeacherFormDto;
import com.project.school_schedule_app.model.Classroom;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassroomService classroomService;
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher createNewTeacher(TeacherFormDto teacherFormDto){

        Teacher teacher = new Teacher();
        teacher.setName(teacherFormDto.name());
        if (teacherFormDto.classId()!=null){
            Classroom classroom = classroomService.getClassroomById(teacherFormDto.classId());
            teacher.setHomeClassroom(classroom);
        }
        return teacherRepository.save(teacher);
    }

}
