package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.dto.StudentGroupFormDto;
import com.project.school_schedule_app.dto.SubjectFormDto;
import com.project.school_schedule_app.model.StudentGroup;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.model.Teacher;
import com.project.school_schedule_app.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentGroupWebController {
    @Autowired
    private StudentGroupService studentGroupService;
    @GetMapping("/groups")
    public String showTeacherPage(Model model) {
        // 1. Данные для таблицы
        List<StudentGroup> allGroups = studentGroupService.getAllStudentsGroup();


        model.addAttribute("newGroupForm", new StudentGroupFormDto("", 0));


        model.addAttribute("groupsList", allGroups);

        return "groups";
    }

    @PostMapping("/groups/add")
    public String addNewGroup(@ModelAttribute("newGroupForm") StudentGroupFormDto dto) {
        studentGroupService.createNewStudentGroup(dto);
        return "redirect:/groups";
    }
}
