package com.project.school_schedule_app.service;

import com.project.school_schedule_app.dto.ClassroomFormDto;
import com.project.school_schedule_app.dto.TeacherFormDto;
import com.project.school_schedule_app.model.Classroom;
import com.project.school_schedule_app.repository.ClassroomRepository;
import com.project.school_schedule_app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    public Classroom createNewClassroom(ClassroomFormDto dto){
        Classroom classroom = new Classroom();
        classroom.setRoomNumber(dto.roomNumber());
        return classroomRepository.save(classroom);
    }
    public Classroom getClassroomById(Long id) {

        return classroomRepository.findById(id).orElse(null);
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
}
