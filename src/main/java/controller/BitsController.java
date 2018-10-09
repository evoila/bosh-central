package controller;

import model.BoshPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bits")
public class BitsController {

    @PostMapping(value = "/{uuid}")
    public ResponseEntity<BoshPackage> uploadBlob(@PathVariable(value = "uuid") String uuid) {
        return null;
    }
}