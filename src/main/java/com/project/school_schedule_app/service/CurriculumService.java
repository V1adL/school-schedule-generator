package com.project.school_schedule_app.service;

import com.project.school_schedule_app.dto.CurriculumFormDto;
import com.project.school_schedule_app.model.CurriculumItem;
import com.project.school_schedule_app.model.StudentGroup;
import com.project.school_schedule_app.model.Subject;
import com.project.school_schedule_app.repository.CurriculumItemRepository;
import com.project.school_schedule_app.repository.StudentGroupRepository;
import com.project.school_schedule_app.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {
    @Autowired
    private  CurriculumItemRepository curriculumRepository;
    @Autowired
    private  StudentGroupRepository groupRepository;
    @Autowired
    private SubjectRepository subjectRepository;




    public List<CurriculumItem> getAllCurriculumItems() {
        return curriculumRepository.findAll();
    }



    public CurriculumItem createCurriculumItem(CurriculumFormDto dto) {

        StudentGroup group = groupRepository.findById(dto.groupId()).orElse(null);

        Subject subject = subjectRepository.findById(dto.subjectId()).orElse(null);

        CurriculumItem item = new CurriculumItem();
        item.setStudentGroup(group);
        item.setSubject(subject);
        item.setHoursPerWeek(dto.hoursPerWeek());

        return curriculumRepository.save(item);
    }
}
