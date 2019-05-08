package uk.gov.landregistry.kinderkat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * DTO defining a UserBase object
 *
 */
@Getter
@Setter
public class UserBase {

    @Size(max=50)
    @ApiModelProperty(notes = "Max size 50.")
    @JsonProperty
    private String title;

    @Size(min=1, max=200)
    @ApiModelProperty(notes = "Max size 200.")
    @JsonProperty
    private String firstName;

    @Size(min=1, max=100)
    @ApiModelProperty(notes = "Max size 100.")
    @JsonProperty
    private String lastName;

    @Size(max=100)
    @ApiModelProperty(notes = "Max size 100.")
    @JsonProperty
    private String tel;

    @Email
    @ApiModelProperty(notes = "Must be valid email format")
    @JsonProperty
    private String email;

}