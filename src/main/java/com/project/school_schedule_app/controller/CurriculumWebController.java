package com.project.school_schedule_app.controller;

import com.project.school_schedule_app.dto.CurriculumFormDto;
import com.project.school_schedule_app.model.CurriculumItem;
import com.project.school_schedule_app.model.StudentGroup;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.service.CurriculumService;
import com.project.school_schedule_app.service.StudentGroupService;
import com.project.school_schedule_app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CurriculumWebController {
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private StudentGroupService studentGroupService;
    @Autowired
    private SubjectService subjectService;


    @GetMapping("/curriculum")
    public String showCurriculumPage(Model model) {

        List<CurriculumItem> allItems = curriculumService.getAllCurriculumItems();


        List<StudentGroup> allGroups = studentGroupService.getAllStudentsGroup();


        List<Subject> allSubjects = subjectService.getAllSubjects();

        model.addAttribute("newCurriculumForm", new CurriculumFormDto(null, null, 0));

        model.addAttribute("itemsList", allItems);
        model.addAttribute("groupsList", allGroups);
        model.addAttribute("subjectsList", allSubjects);

        return "curriculum";
    }

    @PostMapping("/curriculum/add")
    public String addNewCurriculumItem(@ModelAttribute("newCurriculumForm") CurriculumFormDto dto) {
        curriculumService.createCurriculumItem(dto);
        return "redirect:/curriculum";
    }
}
