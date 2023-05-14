package com.belhaid.mahdi.belhaid_mahdi_18011993.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder

public record AuthenticationRequest(
        @Email String email,
        @NotBlank String password
) {


}
