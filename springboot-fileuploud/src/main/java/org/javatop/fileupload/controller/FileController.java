package org.javatop.fileupload.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-26 20:51
 * @description :
 */

@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final Path fileStorageLocation;

    public FileController(@Value("${file.upload-dir}") String uploadDir) {
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "Please select a file to upload.";
            }

            // Normalize file name
            // String fileName = file.getOriginalFilename();
            // Path targetLocation = this.fileStorageLocation.resolve(fileName);
            // Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


            // Normalize file name
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + fileExtension;

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return "File uploaded successfully: " + fileName;
        } catch (IOException ex) {
            return "Could not upload the file: " + ex.getMessage();
        }
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public static void main(String[] args) {
        String originalFileName = "14.png";
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        System.out.println("fileExtension = " + fileExtension);
    }
}

