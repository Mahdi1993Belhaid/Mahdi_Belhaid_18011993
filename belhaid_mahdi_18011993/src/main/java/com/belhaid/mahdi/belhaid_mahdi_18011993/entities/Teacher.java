package com.belhaid.mahdi.belhaid_mahdi_18011993.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teacher {
    @SequenceGenerator(
            name="teacher_id",
            sequenceName = "teacher_id",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_id"
    )
    private long teacherId;
    @Embedded
    private FullName fullName;


    
}
