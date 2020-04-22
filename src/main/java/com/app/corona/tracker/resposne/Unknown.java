package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Unknown {
 private Integer active;
 private Integer confirmed;
 private Integer deceased;
 private Integer recovered;

 @JsonProperty("delta")
 Delta delta;

}