package com.blw_project.harmuz.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "vendors")
public class Vendor {

    @Id
    private String id;

    @NotBlank
    private String companyName;

    @Email
    private String email;

    @NotBlank
    private String contactPerson;

    @NotBlank
    private String password;

    private Set<Role> roles;
    private AccountStatus status;

    /** Uploaded docs **/
    private String licensePath;
    private String signatoryIdPath;
    private String logoPath;
}