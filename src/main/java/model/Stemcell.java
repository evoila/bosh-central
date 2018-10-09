package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stemcell {
    private String family;

    @JsonProperty("major_version")
    private int majorVersion;

    @JsonProperty("minor_version")
    private int minorVersion;

    public Stemcell(String family, int majorVersion, int minorVersion) {
        this.family = family;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
    }

    public Stemcell() {
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
}
