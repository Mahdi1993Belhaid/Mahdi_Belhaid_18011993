package com.belhaid.mahdi.belhaid_mahdi_18011993.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder

public record  AuthenticationResponse (

         String accessToken,
         String refreshToken
){


}
