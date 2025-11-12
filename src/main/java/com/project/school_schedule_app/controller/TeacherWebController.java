package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.dto.TeacherFormDto;
import com.project.school_schedule_app.model.Classroom;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.service.ClassroomService;
import com.project.school_schedule_app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherWebController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/teachers")
    public String showTeacherPage(Model model) {
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        model.addAttribute("newTeacherForm", new TeacherFormDto("", null));
        model.addAttribute("classroomsList", classrooms);
        model.addAttribute("teachersList", allTeachers);

        return "teachers";
    }

    @PostMapping("/teachers/add")
    public String addNewTeacher(@ModelAttribute("newTeacherForm") TeacherFormDto dto) {
        teacherService.createNewTeacher(dto);
        return "redirect:/teachers";
    }
}
