package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Kolkata {
 private Integer active;
 private Integer confirmed;
 private Integer deceased;
 private Integer recovered;

 @JsonProperty("delta")
 Delta delta;
}