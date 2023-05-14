package com.belhaid.mahdi.belhaid_mahdi_18011993.repositories;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    @Query(
            value = " SELECT s FROM Student s JOIN s.schoolClass c JOIN c.teacher t   " +
                    " WHERE c.name =:className or t.fullName.firstName =:firstName "
    )
    public Page<Student> findStudents(@Param("firstName") String firstName , @Param("className") String className, Pageable pageable);
}
