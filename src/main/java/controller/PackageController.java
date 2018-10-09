package controller;

import model.BoshPackage;
import model.PackageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(value = "/package")
public class PackageController {

    static HashMap<String, BoshPackage> database = new HashMap<String, BoshPackage>();


    @PostMapping(value = "/{vendor}/{packageName}/{version}")
    public ResponseEntity<UUID> uploadSpecfile(
            @PathVariable(value="vendor") String vendor,
            @PathVariable(value="packageName") String packageName,
            @PathVariable(value="version") String version,
            @RequestParam(value="stemcellFamily") String stemcellFamily,
            @RequestParam(value = "stemcellMajor") int stemcellMajor,
            @RequestParam(value = "stemcellMajor") int stemcellMinor,
            @RequestBody() Spec spec
    ){

        UUID uuid = UUID.randomUUID();
        BoshPackage boshPackage = new BoshPackage(packageName, version,
                stemcellFamily, stemcellMajor,
                stemcellMinor, new Vendor(vendor), UUID.randomUUID(), spec);

        database.put(uuid.toString(), boshPackage);


        return new ResponseEntity<UUID>(uuid, HttpStatus.CREATED);

    }
    @GetMapping(value = "")
    public ResponseEntity<PackageResponse> getPackageInformation(
            @RequestParam(value = "vendor") String vendor,
            @RequestParam(value = "packageName") String packageName,
            @RequestParam(value = "version") String version,
            @RequestParam(value = "stemcellFamily") String stemcellFamily,
            @RequestParam(value = "stemcellMajor") int stemcellMajor,
            @RequestParam(value = "stemcellMinor") int stemcellMinor
    ) {
                return null;
    }
}
