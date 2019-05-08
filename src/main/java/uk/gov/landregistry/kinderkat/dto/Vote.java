package uk.gov.landregistry.kinderkat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class Vote {
    @Size(max=256)
    @ApiModelProperty(notes = "Max size 256.")
    @JsonProperty
    private String image_id;

    @Size(max=3, min=1)
    @ApiModelProperty(notes = "Minimum is 1 and maximum value is 3")
    @JsonProperty
    private int vote;

    @Size(max=256)
    @ApiModelProperty(notes = "Max size 256.")
    @JsonProperty
    private String kat_name;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getKat_name() {
        return kat_name;
    }

    public void setKat_name(String kat_name) {
        this.kat_name = kat_name;
    }
}

