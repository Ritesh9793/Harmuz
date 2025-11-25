package com.blw_project.harmuz.service.impl;

import com.blw_project.harmuz.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${harmuz.upload.base-path:uploads}")
    private String uploadBasePath;

    @Override
    public String store(MultipartFile file, String subDir) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path dirPath = Paths.get(uploadBasePath, subDir);
            Files.createDirectories(dirPath);
            Path fullPath = dirPath.resolve(filename);
            Files.write(fullPath, file.getBytes());
            return fullPath.toString();
        } catch (IOException ex) {
            log.error("Failed to store file", ex);
            throw new RuntimeException("File upload failed");
        }
    }
}