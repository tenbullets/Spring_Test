package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.vafer.jdeb.shaded.commons.io.FilenameUtils;
import org.vafer.jdeb.shaded.commons.io.IOUtils;
import ru.itis.spring_test.models.FileInfo;
import ru.itis.spring_test.repository.FilesRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FilesStorageServiceImpl implements FilesStorageService {

    @Autowired
    FilesRepository filesRepository;

    @Value("${storage.path}")
    private String storagePath;

    @Override
    public String saveFile(MultipartFile uploadFile) {
        String storageName = UUID.randomUUID() + "." + FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        FileInfo file = FileInfo.builder()
                .type(uploadFile.getContentType())
                .size(uploadFile.getSize())
                .originalName(uploadFile.getOriginalFilename())
                .storageFileName(storageName)
                .url(storagePath + "\\" + storageName)
                .build();

        try {
            Files.copy(uploadFile.getInputStream(), Paths.get(storagePath, storageName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        filesRepository.save(file);
        return file.getOriginalName();
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesRepository.findByOriginalName(fileName);
        response.setContentType(fileInfo.getType());

        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
