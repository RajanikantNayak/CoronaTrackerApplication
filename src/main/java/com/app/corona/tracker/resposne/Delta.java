package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "confirmed",
        "deceased",
        "recovered"
})
public class Delta {
 @JsonProperty("confirmed")
 private Integer confirmed;
 @JsonProperty("deceased")
 private Integer deceased;
 @JsonProperty("recovered")
 private Integer recovered;
 @JsonIgnore
 private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}