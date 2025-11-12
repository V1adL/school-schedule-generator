package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup,Long> {
}
