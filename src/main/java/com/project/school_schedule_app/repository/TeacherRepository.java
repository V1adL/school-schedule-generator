package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
