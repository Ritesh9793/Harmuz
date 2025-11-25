package com.blw_project.harmuz.service.impl;

import com.blw_project.harmuz.dto.*;
import com.blw_project.harmuz.entity.*;
import com.blw_project.harmuz.repository.*;
import com.blw_project.harmuz.service.*;
import com.blw_project.harmuz.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileStorageService fileStorageService;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public AuthResponse registerCustomer(RegistrationRequest request,
                                         MultipartFile idDocument,
                                         MultipartFile photo) {

        if(customerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        String docPath = fileStorageService.store(idDocument, "customers/docs");
        String photoPath = fileStorageService.store(photo, "customers/photos");

        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(Role.CUSTOMER))
                .status(AccountStatus.PENDING_VERIFICATION)
                .idDocumentPath(docPath)
                .photoPath(photoPath)
                .build();

        customerRepository.save(customer);
        String token = jwtUtil.generateToken(customer.getEmail(), Set.of(Role.CUSTOMER.name()));
        return new AuthResponse(token);
    }

    @Override
    @Transactional
    public AuthResponse registerVendor(VendorRegistrationRequest request,
                                       MultipartFile license,
                                       MultipartFile signatoryId,
                                       MultipartFile logo) {

        if(vendorRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        String licensePath = fileStorageService.store(license, "vendors/licenses");
        String signatoryPath = fileStorageService.store(signatoryId, "vendors/ids");
        String logoPath = logo != null ? fileStorageService.store(logo, "vendors/logos") : null;

        Vendor vendor = Vendor.builder()
                .companyName(request.getCompanyName())
                .email(request.getEmail())
                .contactPerson(request.getContactPerson())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(Role.VENDOR))
                .status(AccountStatus.PENDING_VERIFICATION)
                .licensePath(licensePath)
                .signatoryIdPath(signatoryPath)
                .logoPath(logoPath)
                .build();

        vendorRepository.save(vendor);
        String token = jwtUtil.generateToken(vendor.getEmail(), Set.of(Role.VENDOR.name()));
        return new AuthResponse(token);
    }
}