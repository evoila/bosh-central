package application.controller;

import application.beans.MatcherBean;
import application.model.BoshPackage;
import application.model.Stemcell;
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


    @PostMapping(value = "/{packageName}/")
    public ResponseEntity<UUID> uploadSpecfile(
            @PathVariable(value="packageName") String packageName,
            @RequestBody() BoshPackage boshPackage
    ){

        UUID uuid = UUID.randomUUID();
        boshPackage.setUuid(uuid);

        database.add(boshPackage);

        return new ResponseEntity<UUID>(uuid, HttpStatus.CREATED);

    }
    @GetMapping(value = "")
    public ResponseEntity<List<BoshPackage>> getPackageInformation(
            @RequestParam(value = "vendor") String vendor,
            @RequestParam(value = "packageName") String packageName,
            @RequestParam(value = "version") String version,
            @RequestParam(value = "stemcellFamily") String stemcellFamily,
            @RequestParam(value = "stemcellMajor") int stemcellMajor,
            @RequestParam(value = "stemcellMinor") int stemcellMinor
    ) {
        Stemcell stemcell = new Stemcell(stemcellFamily, stemcellMajor, stemcellMinor);
        BoshPackage boshPackage = new BoshPackage(packageName, version, vendor, stemcell);
        List<BoshPackage> results = this.matcherBean.searchForMatches(boshPackage);
        results.forEach(k -> k.setDependencies(this.matcherBean.getActualDependencies(k.getDependencies())));
        return new ResponseEntity<List<BoshPackage>>(results, HttpStatus.FOUND);

    }
}
