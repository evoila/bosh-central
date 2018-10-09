package application.beans;

import application.controller.PackageController;
import application.model.BoshPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatcherBean {

    public List<BoshPackage> searchForMatches(BoshPackage bp) {
        return PackageController.database.stream().filter(d -> {

            if (!d.getName().equals(bp.getVendor()))
                return false;

            if (bp.getVersion() != null) {
                if (!d.getVersion().equals(bp.getVersion()))
                    return false;
            }
            if (bp.getStemcell() != null) {
                if (bp.getStemcell().getFamily() != null) {
                    if (!d.getStemcell().getFamily().equals(bp.getStemcell().getFamily()))
                        return false;
                }
                if (bp.getStemcell().getMajorVersion() != 0) {
                    if (!(d.getStemcell().getMajorVersion() == bp.getStemcell().getMajorVersion()))
                        return false;
                }
                if (bp.getStemcell().getMinorVersion() != 0) {
                    if (!(d.getStemcell().getMinorVersion() == bp.getStemcell().getMinorVersion()))
                        return false;
                }
            }
            if (bp.getVendor() != null) {
                if (!d.getVendor().equals(bp.getVendor()))
                    return false;
            }
            return false;

        }).collect(Collectors.toList());
    }

    public List<BoshPackage> getActualDependencies(List<BoshPackage> dependencies) {
        List<BoshPackage> returnValue = new ArrayList<>();
        for (BoshPackage dependencie : dependencies) {
            List<BoshPackage> list = PackageController.database.stream().filter(k -> k.equals(dependencie)).collect(Collectors.toList());
            if (list != null) {
                returnValue.add(list.get(0));
            } else {
                returnValue.add(dependencie);
            }
        }
        return returnValue;
    }

}
