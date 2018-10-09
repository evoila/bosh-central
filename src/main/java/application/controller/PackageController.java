package application.controller;

import application.beans.MatcherBean;
import application.model.BoshPackage;
import application.model.Stemcell;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/package")
public class PackageController {
    private MatcherBean matcherBean;
    public PackageController(MatcherBean matcherBean){
        this.matcherBean = matcherBean;
    }

    public static List<BoshPackage> database = new ArrayList<>();


    @PostMapping(value = "")
    public ResponseEntity<String> uploadSpecfile(
            @RequestBody() BoshPackage boshPackage
    ){

        UUID uuid = UUID.randomUUID();
        boshPackage.setUuid(uuid);

        database.add(boshPackage);

        String uuidAsJson = new JSONObject()
                .put("urn", "urn:package:" + uuid.toString())
                .toString();

        return new ResponseEntity<>(uuidAsJson, HttpStatus.CREATED);

    }
    @GetMapping(value = "")
    public ResponseEntity<List<BoshPackage>> getPackageInformation(
            @RequestParam(value = "vendor", required = false) String vendor,
            @RequestParam(value = "packageName") String packageName,
            @RequestParam(value = "version", required = false) String version,
            @RequestParam(value = "stemcellFamily", required = false) String stemcellFamily,
            @RequestParam(value = "stemcellMajor", required = false) Integer stemcellMajor,
            @RequestParam(value = "stemcellMinor", required = false) Integer stemcellMinor
    ) {
        Stemcell stemcell = new Stemcell(stemcellFamily, stemcellMajor, stemcellMinor);
        BoshPackage boshPackage = new BoshPackage(packageName, version, vendor, stemcell);
        List<BoshPackage> results = this.matcherBean.searchForMatches(boshPackage);
        results.forEach(k -> k.setDependencies(this.matcherBean.getActualDependencies(k.getDependencies())));
        return new ResponseEntity<List<BoshPackage>>(results, HttpStatus.OK);
    }
}
