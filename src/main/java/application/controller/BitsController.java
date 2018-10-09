package application.controller;

import application.model.BoshPackage;
import application.model.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bits")
public class BitsController {

    private static final Logger log = LoggerFactory.getLogger(BitsController.class);

    private StorageService storageService;

    public BitsController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/{uuid}")
    public ResponseEntity<BoshPackage> uploadBlob(
            @PathVariable(value = "uuid") UUID uuid,
            @RequestParam("file") MultipartFile file) {

        String filepath = storageService.store(file);

        getBoshPackageById(uuid).setFileUri(filepath);

        log.debug("Successfully uploaded " + file.getOriginalFilename() + " to storage.");

        return new ResponseEntity<>(getBoshPackageById(uuid), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{uuid}")
    public Resource downloadBlob(@PathVariable(value = "uuid") UUID uuid) throws MalformedURLException {

        log.debug("Successfully loaded file for UUID = " + uuid);

        return storageService.loadAsResource(getBoshPackageById(uuid).getFileUri());
    }

    private BoshPackage getBoshPackageById(UUID uuid) {
        List<BoshPackage> returnValue =  PackageController.database.stream().filter(k -> k.getUuid() == uuid).collect(Collectors.toList());
        if(!returnValue.isEmpty()) {
            return returnValue.get(0);
        } else {
            return null;
        }
    }
}