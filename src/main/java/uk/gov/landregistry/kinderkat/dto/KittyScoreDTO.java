
package uk.gov.landregistry.kinderkat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class KittyScoreDTO {

    @Size(max=256)
    @ApiModelProperty(notes = "Max size 256.")
    @JsonProperty(value = "img_id")
    private String imgId;

    @JsonProperty
    private long score;

    public KittyScoreDTO(String imgId, long score) {
        this.imgId = imgId;
        this.score = score;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

}
