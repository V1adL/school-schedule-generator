package com.project.school_schedule_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_classroom_id", nullable = true)
    private Classroom homeClassroom;

    public Teacher(String name, Classroom homeClassroom) {
        this.name = name;
        this.homeClassroom = homeClassroom;
    }
}
