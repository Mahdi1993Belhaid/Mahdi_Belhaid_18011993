package com.belhaid.mahdi.belhaid_mahdi_18011993.controllers;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Student;
import com.belhaid.mahdi.belhaid_mahdi_18011993.services.SchoolManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/management/students")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class SchoolManagementController {
    private final SchoolManagementService schoolManagementService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    List<Student> getStudents(
            @RequestParam String teacherFirstName,
            @RequestParam String className,
            @RequestParam(required = false,name = "page",defaultValue ="0") int page,
            @RequestParam(required = false,name="size",defaultValue = "10") int size
            ){


        return schoolManagementService.getAllStudents(teacherFirstName,className,page,size).getContent();
    }
}
