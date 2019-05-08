package uk.gov.landregistry.kinderkat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import uk.gov.landregistry.kinderkat.utils.TimestampToDB2StringSerializer;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DTO defining a UserResp object
 *
 */
@Getter
@Setter
@ApiModel (value="User_Response")
public class UserResp extends UserBase{

    @JsonProperty
    private String userId;

    @ApiModelProperty(notes = "Format: yyyy-mm-dd-hh.mm.ss.ssssss")
    @JsonProperty
    @JsonSerialize(using = TimestampToDB2StringSerializer.class)
    private Timestamp lastSeen;

}