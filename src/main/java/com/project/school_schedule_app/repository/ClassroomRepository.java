package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
