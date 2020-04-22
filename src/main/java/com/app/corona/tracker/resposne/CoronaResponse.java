package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"countryName", "confirmed", "deceased", "recovered", "lastUpdateDate", "stateWise"})
public class CoronaResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("countryName")
    private String countryName = "India";
    private String confirmed;
    private String deceased;
    private String recovered;
    private String lastUpdateDate;
    @JsonProperty("stateWise")
    private List<StateWiseData> stateWise = new ArrayList<>();


}
