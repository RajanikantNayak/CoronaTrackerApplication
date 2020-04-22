package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateWiseData {
    private String stateName;
    private String confirmed;
    private String active;
    private String deceased;
    private String recovered;
    @JsonProperty("districtWise")
    private List<DistrictDataVo> districtDataVoList = new ArrayList<>();
}
