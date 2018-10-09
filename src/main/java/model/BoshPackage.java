package model;

import java.util.UUID;

public class BoshPackage {
    private String name;
    private String version;

    private String stemcellFamily;
    private int stemcellMajor;
    private int stemcellMinor;

    private Vendor vendor;

    private UUID uuid;

    private Spec spec;

    private String fileUri;

    public BoshPackage(String name, String version,
                       String stemcellFamily, int stemcellMajor, int stemcellMinor,
                       Vendor vendor, UUID uuid, Spec spec) {
        this.name = name;
        this.version = version;
        this.stemcellFamily = stemcellFamily;
        this.stemcellMajor = stemcellMajor;
        this.stemcellMinor = stemcellMinor;
        this.vendor = vendor;
        this.uuid = uuid;
        this.spec = spec;
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

    public String getStemcellFamily() {
        return stemcellFamily;
    }

    public void setStemcellFamily(String stemcellFamily) {
        this.stemcellFamily = stemcellFamily;
    }

    public int getStemcellMajor() {
        return stemcellMajor;
    }

    public void setStemcellMajor(int stemcellMajor) {
        this.stemcellMajor = stemcellMajor;
    }

    public int getStemcellMinor() {
        return stemcellMinor;
    }

    public void setStemcellMinor(int stemcellMinor) {
        this.stemcellMinor = stemcellMinor;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }
}
