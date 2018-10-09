package controller;

import model.BoshPackage;
import model.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @PathVariable(value = "uuid") String uuid,
            @RequestParam("file") MultipartFile file) {

        storageService.store(file);

        log.debug("Successfully uploaded " + file.getOriginalFilename() + " to storage.");

        return new ResponseEntity<>(PackageController.database.get(uuid), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{uuid}")
    public Resource downloadBlob(@PathVariable(value = "uuid") String uuid) {
        return null;
    }
}