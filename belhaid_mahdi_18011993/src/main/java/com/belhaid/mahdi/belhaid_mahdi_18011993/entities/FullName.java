package com.belhaid.mahdi.belhaid_mahdi_18011993.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FullName {
    private String firstName;
    private String lastName;
}
