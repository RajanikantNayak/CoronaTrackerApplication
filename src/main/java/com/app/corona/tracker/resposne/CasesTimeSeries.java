package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CasesTimeSeries {
    private String dailyconfirmed;
    private String dailydeceased;
    private String dailyrecovered;
    private String date;
    private String totalconfirmed;
    private String totaldeceased;
    private String totalrecovered;

}
