package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictWiseData {

    @JsonProperty("Andaman and Nicobar Islands")
    private AndamanandNicobarIslands andamanandNicobarIslands;

    @JsonProperty("Andhra Pradesh")
    private AndhraPradesh andhraPradeshObject;

    @JsonProperty("Arunachal Pradesh")
    private ArunachalPradesh arunachalPradeshObject;

    @JsonProperty("Assam")
    private Assam assam;

    @JsonProperty("Bihar")
    private Bihar bihar;

    @JsonProperty("Chandigarh")
    private Chandigarh chandigarh;

    @JsonProperty("Chhattisgarh")
    private Chhattisgarh chhattisgarh;

    @JsonProperty("Delhi")
    private Delhi delhi;

    @JsonProperty("Goa")
    private Goa goa;

    @JsonProperty("Gujarat")
    private Gujarat gujarat;

    @JsonProperty("Haryana")
    private Haryana haryana;

    @JsonProperty("HimachalPradesh")
    private HimachalPradesh himachalPradesh;

    @JsonProperty("Jammu and Kashmir")
    private JammuandKashmir jammuandKashmir;

    @JsonProperty("Jharkhand")
    private Jharkhand jharkhand;

    @JsonProperty("Karnataka")
    private Karnataka karnataka;

    @JsonProperty("Kerala")
    private Kerala kerala;

    @JsonProperty("Ladakh")
    private Ladakh ladakh;

    @JsonProperty("Madhya Pradesh")
    private MadhyaPradesh madhyaPradesh;

    @JsonProperty("Maharashtra")
    private Maharashtra maharashtra;

    @JsonProperty("Manipur")
    private Manipur manipur;

    @JsonProperty("Meghalaya")
    private Meghalaya meghalaya;

    @JsonProperty("Mizoram")
    private Mizoram mizoram;

    @JsonProperty("Odisha")
    private Odisha odisha;

    @JsonProperty("Puducherry")
    private Puducherry puducherry;

    @JsonProperty("Punjab")
    private Punjab punjab;

    @JsonProperty("Rajasthan")
    private Rajasthan rajasthan;

    @JsonProperty("Tamil Nadu")
    private TamilNadu tamilNadu;

    @JsonProperty("Telangana")
    private Telangana telanganaObject;

    @JsonProperty("Tripura")
    private Tripura tripura;

    @JsonProperty("Uttar Pradesh")
    private UttarPradesh uttarPradesh;

    @JsonProperty("Uttarakhand")
    private Uttarakhand uttarakhand;

    @JsonProperty(" West Bengal")
    private WestBengal westBengal;
}
