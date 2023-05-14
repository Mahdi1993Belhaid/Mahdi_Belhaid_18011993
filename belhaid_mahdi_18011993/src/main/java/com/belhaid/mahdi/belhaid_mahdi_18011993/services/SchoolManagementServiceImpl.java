package com.belhaid.mahdi.belhaid_mahdi_18011993.services;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.SchoolClass;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Student;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Teacher;
import com.belhaid.mahdi.belhaid_mahdi_18011993.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SchoolManagementServiceImpl implements SchoolManagementService{
    private final StudentRepository studentRepository;
    @Override
    public Teacher addTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public SchoolClass addClass(SchoolClass schoolClass) {
        return null;
    }

    @Override
    public Page<Student> getAllStudents(String firstName, String className,int page,int size) {
        Pageable paging = PageRequest.of(page, size);
        return studentRepository.findStudents(firstName,className,paging);
    }
}
