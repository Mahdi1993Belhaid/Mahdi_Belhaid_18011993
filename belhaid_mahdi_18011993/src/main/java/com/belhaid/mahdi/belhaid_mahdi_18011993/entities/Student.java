package com.belhaid.mahdi.belhaid_mahdi_18011993.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    @SequenceGenerator(
            name="student_id",
            sequenceName = "student_id",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id"
    )
    private long studentId;
    @Embedded
    private FullName fullName;
    @ManyToOne(
            fetch = FetchType.EAGER


    )
    @JoinColumn(
            name = "class_pk",
            referencedColumnName = "classId"
    )
    private SchoolClass schoolClass ;
}
