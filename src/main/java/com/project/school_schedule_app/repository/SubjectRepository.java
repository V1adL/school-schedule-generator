package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.Lesson;
import com.project.school_schedule_app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
