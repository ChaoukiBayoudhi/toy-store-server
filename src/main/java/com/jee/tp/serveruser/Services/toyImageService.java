package com.jee.tp.serveruser.Services;

import com.jee.tp.serveruser.Exceptions.FileStorageException;
import com.jee.tp.serveruser.Exceptions.fileNotFoundException;
import com.jee.tp.serveruser.Models.toyImage;
import com.jee.tp.serveruser.Repositories.toyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class toyImageService {
    private static final String FILE_DIRECTORY = "/ppp/files";
    @Autowired
    private toyImageRepository dbFileRepository;

    public toyImage storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            toyImage dbFile = new toyImage(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public toyImage getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new fileNotFoundException("File not found with id " + fileId));
    }

    public void storeInlocalFile(MultipartFile file) throws IOException {
        Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }


}
