package com.blw_project.harmuz.service;

import com.blw_project.harmuz.dto.*;
import org.springframework.web.multipart.MultipartFile;

public interface RegistrationService {

    AuthResponse registerCustomer(RegistrationRequest request,
                                  MultipartFile idDocument,
                                  MultipartFile photo);

    AuthResponse registerVendor(VendorRegistrationRequest request,
                                MultipartFile license,
                                MultipartFile signatoryId,
                                MultipartFile logo);
}