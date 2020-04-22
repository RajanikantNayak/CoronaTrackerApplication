package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictData {
 @JsonProperty("Hooghly")
 private Hooghly hooghly;
 @JsonProperty("Howrah")
 private Howrah howrah;
 @JsonProperty("Kalimpong")
 private Kalimpong kalimpong;
 private Kolkata kolkata;
 private MedinipurEast medinipurEast;
 private Nadia NadiaObject;
 private North24Parganas north24Parganas;
 private South24Parganas south24Parganas;
 private Unknown unknown;
 @JsonProperty("North and Middle Andaman")
 private NorthandMiddleAndaman northandMiddleAndaman;

 @JsonProperty("South Andaman")
 private SouthAndaman southAndaman;

 @JsonProperty("East Delhi")
 private EastDelhi eastDelhi;
 @JsonProperty("New Delhi")
 private NewDelhi newDelhi;
 @JsonProperty("North Delhi")
 private NorthDelhi northDelhi;
 @JsonProperty("North East Delhi")
 private NorthEastDelhi northEastDelhi;
 @JsonProperty("North West Delhi")
 private NorthWestDelhi northWestDelhi;
 @JsonProperty("South Delhi")
 private SouthDelhi southDelhi;
 @JsonProperty("South West Delhi")
 private SouthWestDelhi southWestDelhi;
 @JsonProperty("West Delhi")
 private WestDelhi westDelhi;

 //chattisgarh
 @JsonProperty("Bilaspur")
 private Bilaspur bilaspur;
 @JsonProperty("Durg")
 private Durg durg;
 @JsonProperty("Korba")
 private Korba korba;
 @JsonProperty("Raipur")
 private Raipur raipur;
 @JsonProperty("Rajnandgaon")
 private Rajnandgaon rajnandgaon;

 //Chandigarh district
 @JsonProperty("Chandigarh")
 private ChandigarhDist chandigarh;

 //bihar district
 private Begusarai begusarai;
 private Bhagalpur bhagalpur;
 private Bhojpur bhojpur;
 private Buxar buxar;
 private Gaya gaya;
 private Gopalganj gopalganj;
 private Lakhisarai lakhisarai;
 private Munger munger;
 private Nalanda nalanda;
 private Nawada nawada;
 private Patna patna;
 private Saran saran;
 private Siwan siwan;
 private Vaishali vaishali;
}


