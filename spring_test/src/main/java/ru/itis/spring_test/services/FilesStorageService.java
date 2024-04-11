package ru.itis.spring_test.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FilesStorageService {
    String saveFile(MultipartFile uploadFile);

    void writeFileToResponse(String fileName, HttpServletResponse response);
}
