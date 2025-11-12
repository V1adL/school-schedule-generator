package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.dto.SubjectFormDto;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.service.SubjectService;
import com.project.school_schedule_app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectWebController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/subjects")
    public String showTeacherPage(Model model) {
        List<Subject> allSubjects = subjectService.getAllSubjects();

        List<Teacher> allTeachers = teacherService.getAllTeachers();

        model.addAttribute("newSubjectForm", new SubjectFormDto("", null));

        model.addAttribute("subjectsList", allSubjects);
        model.addAttribute("teachersList", allTeachers);

        return "subjects";
    }
    @PostMapping("/subjects/add")
    public String addNewTeacher(@ModelAttribute("newSubjectForm") SubjectFormDto dto) {
        subjectService.createNewTeacher(dto);
        return "redirect:/subjects";
    }
}
