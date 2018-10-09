package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stemcell {
    private String family;

    @JsonProperty("major_version")
    private String majorVersion;

    @JsonProperty("minor_version")
    private String minorVersion;


}
