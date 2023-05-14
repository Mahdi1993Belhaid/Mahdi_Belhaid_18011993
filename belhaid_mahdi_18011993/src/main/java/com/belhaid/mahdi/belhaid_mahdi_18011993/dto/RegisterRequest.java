package com.belhaid.mahdi.belhaid_mahdi_18011993.dto;


import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder

public record RegisterRequest(
       @NotBlank String firstname,
        String lastname,
       @NotBlank String email,
        @NotBlank  String password,
        Role role
)  {


}
