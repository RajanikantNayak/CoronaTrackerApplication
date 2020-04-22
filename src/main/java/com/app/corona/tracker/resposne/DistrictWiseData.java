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
    private Assam assamObject;

    @JsonProperty("Bihar")
    private Bihar biharObject;

    @JsonProperty("Chandigarh")
    private Chandigarh chandigarhObject;

    @JsonProperty("Chhattisgarh")
    private Chhattisgarh chhattisgarhObject;

    @JsonProperty("Delhi")
    private Delhi delhiObject;

    @JsonProperty("Goa")
    private Goa goaObject;

    @JsonProperty("Gujarat")
    private Gujarat gujaratObject;

    @JsonProperty("Haryana")
    private Haryana haryanaObject;

    @JsonProperty("HimachalPradesh")
    private HimachalPradesh himachalPradeshObject;

    @JsonProperty("Jammu and Kashmir")
    private JammuandKashmir jammuandKashmirObject;

    @JsonProperty("Jharkhand")
    private Jharkhand jharkhandObject;

    @JsonProperty("Karnataka")
    private Karnataka karnatakaObject;

    @JsonProperty("Kerala")
    private Kerala keralaObject;

    @JsonProperty("Ladakh")
    private Ladakh ladakhObject;

    @JsonProperty("Madhya Pradesh")
    private MadhyaPradesh madhyaPradeshObject;

    @JsonProperty("Maharashtra")
    private Maharashtra maharashtraObject;

    @JsonProperty("Manipur")
    private Manipur manipurObject;

    @JsonProperty("Meghalaya")
    private Meghalaya meghalayaObject;

    @JsonProperty("Mizoram")
    private Mizoram mizoramObject;

    @JsonProperty("Odisha")
    private Odisha odishaObject;

    @JsonProperty("Puducherry")
    private Puducherry puducherryObject;

    @JsonProperty("Punjab")
    private Punjab punjabObject;

    @JsonProperty("Rajasthan")
    private Rajasthan rajasthanObject;

    @JsonProperty("Tamil Nadu")
    private TamilNadu tamilNaduObject;

    @JsonProperty("Telangana")
    private Telangana telanganaObject;

    @JsonProperty("Tripura")
    private Tripura tripuraObject;

    @JsonProperty("Uttar Pradesh")
    private UttarPradesh uttarPradeshObject;

    @JsonProperty("Uttarakhand")
    private Uttarakhand uttarakhandObject;

    @JsonProperty(" West Bengal")
    private WestBengal westBengalObject;
}
