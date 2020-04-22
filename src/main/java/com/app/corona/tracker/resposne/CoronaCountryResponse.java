package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoronaCountryResponse {

    @JsonProperty("cases_time_series")
    List<CasesTimeSeries> cases_time_series = new ArrayList<>();

    @JsonProperty("statewise")
    List<Statewise> statewise = new ArrayList<> ();

    @JsonProperty("tested")
    List<Tested> tested = new ArrayList<> ();
}
