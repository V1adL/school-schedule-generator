package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    boolean existsByTeacherAndTimeSlot(Teacher teacher, TimeSlot timeSlot);


    boolean existsByStudentGroupAndTimeSlot(StudentGroup studentGroup, TimeSlot timeSlot);


    boolean existsByClassroomAndTimeSlot(Classroom classroom, TimeSlot timeSlot);
}
