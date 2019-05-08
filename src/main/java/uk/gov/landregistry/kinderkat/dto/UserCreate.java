package uk.gov.landregistry.kinderkat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * DTO defining a User Create object
 *
 */
@Getter
@Setter
@ApiModel (value="User_Create")
public class UserCreate extends UserBase {

    @ApiModelProperty(notes = "The users chosen ID", required = true)
    @JsonProperty
    @NotNull
    private String userId;

}