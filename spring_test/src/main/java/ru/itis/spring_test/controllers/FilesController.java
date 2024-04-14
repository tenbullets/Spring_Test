package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.spring_test.services.FilesStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesController {

    @Autowired
    private FilesStorageService filesStorageService;

    @GetMapping("/files")
    public String getFilesUploadPage() {
        return "file_upload_page";
    }

    @PostMapping("/files")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = filesStorageService.saveFile(file);
        System.out.println(file.getName());
        System.out.println(file);
        return ResponseEntity.ok(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable ("file-name") String fileName, HttpServletResponse response) {
        filesStorageService.writeFileToResponse(fileName, response);
    }
}