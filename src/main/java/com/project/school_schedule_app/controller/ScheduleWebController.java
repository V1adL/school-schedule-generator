package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.model.Lesson;
import com.project.school_schedule_app.service.LessonService;
import com.project.school_schedule_app.service.ScheduleGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScheduleWebController {
    private final ScheduleGeneratorService generatorService; // "Мозг"
    private final LessonService lessonService; // "Просмотрщик"

    @Autowired
    public ScheduleWebController(ScheduleGeneratorService generatorService,
                                 LessonService lessonService) {
        this.generatorService = generatorService;
        this.lessonService = lessonService;
    }


    @GetMapping("/schedule")
    public String showSchedulePage(Model model) {

        List<Lesson> allLessons = lessonService.getAllLessons();
        model.addAttribute("lessonsList", allLessons);

        return "schedule";
    }


    @PostMapping("/schedule/generate")
    public String generateNewSchedule() {

        generatorService.generateSchedule();

        return "redirect:/schedule";
    }
}
