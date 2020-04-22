package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictData {
 /*Hooghly HooghlyObject;
 Howrah HowrahObject;
 Kalimpong KalimpongObject;*/
 private Kolkata KolkataObject;
 private MedinipurEast medinipurEastObject;
 private Nadia NadiaObject;
 private North24Parganas north24ParganasObject;
 private South24Parganas south24Parganas;
 private Unknown UnknownObject;
 @JsonProperty("North and Middle Andaman")
 private NorthandMiddleAndaman northandMiddleAndaman;

 @JsonProperty("South Andaman")
 private SouthAndaman southAndaman;

}


