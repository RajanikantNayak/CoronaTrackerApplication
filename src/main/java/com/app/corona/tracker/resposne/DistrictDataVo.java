package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictDataVo {
    private String districtName;
    private Integer confirmed;
    private Integer active;
    private Integer deceased;
    private Integer recovered;
}
