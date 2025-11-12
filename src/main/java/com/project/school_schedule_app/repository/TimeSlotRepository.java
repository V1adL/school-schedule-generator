package com.project.school_schedule_app.repository;

import com.project.school_schedule_app.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
}
