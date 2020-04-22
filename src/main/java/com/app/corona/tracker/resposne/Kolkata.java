package com.app.corona.tracker.resposne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Kolkata {
 private float active;
 private float confirmed;
 private float deceased;
 private float recovered;
 private Delta DeltaObject;
}