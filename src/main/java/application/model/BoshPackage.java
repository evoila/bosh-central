package application.model;

import java.util.List;
import java.util.UUID;

public class BoshPackage {
    private String name;
    private String version;

    private Stemcell stemcell;

    private String flavor;

    private String description;

    private String vendor;

    private UUID uuid;

    private String os;

    private String arch;

    private String fileUri;

    private List<BoshPackage> dependencies;

    public BoshPackage(String name, String version, String vendor, Stemcell stemcell){
        this.name = name;
        this.version = version;
        this.vendor = vendor;
        this.stemcell = stemcell;
    }


    public BoshPackage(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public Stemcell getStemcell() {
        return stemcell;
    }

    public void setStemcell(Stemcell stemcell) {
        this.stemcell = stemcell;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public List<BoshPackage> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<BoshPackage> dependencies) {
        this.dependencies = dependencies;
    }

    public boolean equals(BoshPackage obj) {
        if(name.equals(obj.name) && version.equals(obj.version) && stemcell.equals(obj.stemcell)
                && vendor.equals(obj.vendor) && flavor.equals(obj.flavor) && os.equals(obj.os)){
            return true;
        }
        return false;
    }
}
