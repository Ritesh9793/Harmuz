package com.blw_project.harmuz.repository;

import com.blw_project.harmuz.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Optional<Vendor> findByEmail(String email);
    boolean existsByEmail(String email);
}