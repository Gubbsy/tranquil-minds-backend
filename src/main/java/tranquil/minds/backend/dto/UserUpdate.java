package tranquil.minds.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DTO defining a User object
 *
 */
@Getter
@Setter
@ApiModel (value="User_Update")
public class UserUpdate {

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