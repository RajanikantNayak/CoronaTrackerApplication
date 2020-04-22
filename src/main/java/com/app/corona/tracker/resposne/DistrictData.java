package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "district",
        "active",
        "confirmed",
        "deceased",
        "recovered",
        "delta"
})
public class DistrictData implements Serializable {
 private static final long serialVersionUID = 1L;
 @JsonProperty("district")
 private String district;
 @JsonProperty("active")
 private Integer active;
 @JsonProperty("confirmed")
 private Integer confirmed;
 @JsonProperty("deceased")
 private Integer deceased;
 @JsonProperty("recovered")
 private Integer recovered;
 @JsonProperty("delta")
 private Delta delta;
 @JsonIgnore
 private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}


