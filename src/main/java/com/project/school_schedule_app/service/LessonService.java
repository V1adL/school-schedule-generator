package com.project.school_schedule_app.service;

import com.project.school_schedule_app.model.Lesson;
import com.project.school_schedule_app.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    private  LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();


        lessons.sort(Comparator
                .comparing((Lesson l) -> l.getTimeSlot().getDayOfWeek())
                .thenComparing(l -> l.getTimeSlot().getStartTime())
                .thenComparing(l -> l.getStudentGroup().getName())
        );

        return lessons;
    }
}
