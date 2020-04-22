package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Statewise {
    private String active;
    private String confirmed;
    private String deaths;
    private String deltaconfirmed;
    private String deltadeaths;
    private String deltarecovered;
    private String lastupdatedtime;
    private String recovered;
    private String state;
    private String statecode;
    private String statenotes;
}
