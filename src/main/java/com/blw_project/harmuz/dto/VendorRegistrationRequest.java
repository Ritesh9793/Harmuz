package com.blw_project.harmuz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VendorRegistrationRequest {

    @NotBlank
    private String companyName;

    @Email
    private String email;

    @NotBlank
    private String contactPerson;

    @NotBlank
    private String password;
}