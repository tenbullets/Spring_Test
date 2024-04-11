package ru.itis.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_test.models.FileInfo;

public interface FilesRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName (String fileName);
    FileInfo findByOriginalName (String originalFileName);
}
