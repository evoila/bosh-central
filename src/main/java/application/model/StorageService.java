package application.model;

import application.exception.FileStorageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * Created by reneschollmeyer, evoila on 09.10.18.
 */
@Service
public class StorageService {

    private final Path fileStorageLocation;

    public StorageService() {
        this.fileStorageLocation = Paths.get("./hackathon-filestorage")
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String store(MultipartFile file, UUID uuid) {

        String fileName = uuid.toString() + ".tgz";

        if(fileName.contains("..")) {
            throw new FileStorageException("Filename contains invalid path sequence " + fileName);
        }

        Path targetLocation = this.fileStorageLocation.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetLocation.toString();
    }

    public Resource loadAsResource(String filepath) throws MalformedURLException {

        Path path = Paths.get(filepath);
        Resource resource = new UrlResource(path.toUri());

        return resource;
    }
}
