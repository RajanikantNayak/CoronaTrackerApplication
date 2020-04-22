package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class North24Parganas {
 private Integer active;
 private Integer confirmed;
 private Integer deceased;
 private Integer recovered;

 @JsonProperty("delta")
 Delta delta;

}