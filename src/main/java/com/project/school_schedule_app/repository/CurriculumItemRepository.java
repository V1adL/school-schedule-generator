package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.CurriculumItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumItemRepository extends JpaRepository<CurriculumItem,Long> {
}
