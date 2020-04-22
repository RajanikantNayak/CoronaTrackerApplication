package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tested {

    private String positivecasesfromsamplesreported;
    private String samplereportedtoday;
    private String source;
    private String testsconductedbyprivatelabs;
    private String totalindividualstested;
    private String totalpositivecases;
    private String totalsamplestested;
    private String updatetimestamp;
}
