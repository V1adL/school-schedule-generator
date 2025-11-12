package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.dto.ClassroomFormDto;
import com.project.school_schedule_app.model.Classroom;
import com.project.school_schedule_app.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ClassroomWebController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classrooms")
    public String showClassroomPage(Model model){
        List<Classroom> classrooms= classroomService.getAllClassrooms();
        model.addAttribute("newClassroomForm", new ClassroomFormDto(""));
        model.addAttribute("classroomsList" , classrooms);
        return "classrooms";
    }

    @PostMapping("/classrooms/add")
    public String addNewClassroom(@ModelAttribute("newClassroomForm") ClassroomFormDto dto){
        classroomService.createNewClassroom(dto);
        return "redirect:/classrooms";
    }
}
