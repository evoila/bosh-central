package application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stemcell {
    private String family;

    @JsonProperty("major_version")
    private int majorVersion;

    @JsonProperty("minor_version")
    private int minorVersion;

    public Stemcell(String family, Integer majorVersion, Integer minorVersion) {
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

    public Integer getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(Integer majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Integer getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }
}
