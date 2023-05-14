package com.belhaid.mahdi.belhaid_mahdi_18011993.repositories;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
