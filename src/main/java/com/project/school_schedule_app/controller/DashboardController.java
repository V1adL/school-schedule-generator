package com.project.school_schedule_app.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {
    @GetMapping("/")
    public String showMainPage(){
        return "index";
    }
}
