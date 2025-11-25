package com.blw_project.harmuz.controller;

import com.blw_project.harmuz.dto.*;
import com.blw_project.harmuz.service.LoginService;
import com.blw_project.harmuz.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;
    private final LoginService loginService;

    // ---- CUSTOMER REGISTRATION ----
    @PostMapping(value = "/register/customer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AuthResponse> registerCustomer(
            @ModelAttribute @Valid RegistrationRequest request,
            @RequestPart("idDocument") MultipartFile idDocument,
            @RequestPart("photo") MultipartFile photo) {

        return ResponseEntity.ok(
                registrationService.registerCustomer(request, idDocument, photo));
    }

    // ---- VENDOR REGISTRATION ----
    @PostMapping(value = "/register/vendor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AuthResponse> registerVendor(
            @ModelAttribute @Valid VendorRegistrationRequest request,
            @RequestPart("license") MultipartFile license,
            @RequestPart("signatoryId") MultipartFile signatoryId,
            @RequestPart(value = "logo", required = false) MultipartFile logo) {

        return ResponseEntity.ok(
                registrationService.registerVendor(request, license, signatoryId, logo));
    }

    // ---- LOGIN ----
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.authenticate(request));
    }
}
