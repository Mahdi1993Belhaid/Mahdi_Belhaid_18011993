package com.belhaid.mahdi.belhaid_mahdi_18011993.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SchoolClass {
    @SequenceGenerator(
            name = "class_id",
            sequenceName = "class_id",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "class_id"

    )
    private long classId;
    @Column(
            nullable = false,
            length = 100,
            unique = true
    )
    private String name;
    @JsonIgnore
    @OneToMany(
            mappedBy = "schoolClass",
            fetch = FetchType.LAZY
    )
    private List<Student>students;
    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(

            name = "teacher_fk",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

}
