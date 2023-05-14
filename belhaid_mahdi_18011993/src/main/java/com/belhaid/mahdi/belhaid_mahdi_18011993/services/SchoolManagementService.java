package com.belhaid.mahdi.belhaid_mahdi_18011993.services;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.SchoolClass;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Student;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  SchoolManagementService {

    public Teacher addTeacher(Teacher teacher);

    public Student addStudent(Student student);
    public SchoolClass addClass(SchoolClass schoolClass);

    public Page<Student> getAllStudents(String firstName , String className, int page,int size);

}
