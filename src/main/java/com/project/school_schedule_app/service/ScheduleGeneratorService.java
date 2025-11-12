package com.project.school_schedule_app.service;

import com.project.school_schedule_app.model.*;
import com.project.school_schedule_app.repository.ClassroomRepository;
import com.project.school_schedule_app.repository.CurriculumItemRepository;
import com.project.school_schedule_app.repository.LessonRepository;
import com.project.school_schedule_app.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ScheduleGeneratorService {

    private final LessonRepository lessonRepository;
    private final CurriculumItemRepository curriculumRepository;
    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public ScheduleGeneratorService(LessonRepository lessonRepository,
                                    CurriculumItemRepository curriculumRepository,
                                    TimeSlotRepository timeSlotRepository,
                                    ClassroomRepository classroomRepository) {
        this.lessonRepository = lessonRepository;
        this.curriculumRepository = curriculumRepository;
        this.timeSlotRepository = timeSlotRepository;

    }


    @Transactional
    public void generateSchedule() {

        lessonRepository.deleteAllInBatch();
        lessonRepository.flush();

        List<CurriculumItem> allTasks = curriculumRepository.findAll();
        List<TimeSlot> allTimeSlots = timeSlotRepository.findAll();
        Collections.shuffle(allTasks);
        Collections.shuffle(allTimeSlots);


        for (CurriculumItem task : allTasks) {

            int hoursPlaced = 0;
            int hoursNeeded = task.getHoursPerWeek();

            StudentGroup group = task.getStudentGroup();
            Subject subject = task.getSubject();
            Teacher teacher = subject.getTeacher();


            for (TimeSlot timeSlot : allTimeSlots) {

                if (hoursPlaced == hoursNeeded) {
                    break;
                }


                if (isTeacherFree(teacher, timeSlot) && isGroupFree(group, timeSlot)) {


                    Classroom availableRoom = findAvailableRoom(teacher, timeSlot);

                    if (availableRoom != null) {

                        Lesson lesson = new Lesson();
                        lesson.setTeacher(teacher);
                        lesson.setSubject(subject);
                        lesson.setStudentGroup(group);
                        lesson.setClassroom(availableRoom);
                        lesson.setTimeSlot(timeSlot);

                        lessonRepository.save(lesson);
                        hoursPlaced++;
                    }
                }
            }


        }

    }


    private boolean isTeacherFree(Teacher teacher, TimeSlot timeSlot) {
        return !lessonRepository.existsByTeacherAndTimeSlot(teacher, timeSlot);
    }


    private boolean isGroupFree(StudentGroup group, TimeSlot timeSlot) {
        return !lessonRepository.existsByStudentGroupAndTimeSlot(group, timeSlot);
    }

    private Classroom findAvailableRoom(Teacher teacher, TimeSlot timeSlot) {


        Classroom homeRoom = teacher.getHomeClassroom();


        if (homeRoom == null) {


            return null;
        }

        if (!lessonRepository.existsByClassroomAndTimeSlot(homeRoom, timeSlot)) {
            return homeRoom;
        }
        return null;
    }
}
