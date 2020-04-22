package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Delta {
 private Integer confirmed;
 private Integer deceased;
 private Integer recovered;

}