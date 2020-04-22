package com.app.corona.tracker.command;

import com.app.corona.tracker.resposne.CoronaCountryResponse;
import com.app.corona.tracker.resposne.CoronaResponse;
import com.app.corona.tracker.resposne.DistrictWiseData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class CoronaExtCommand {

    private static final Logger logger = LoggerFactory.getLogger(CoronaExtCommand.class);

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    public DistrictWiseData coronaCasesByAllState() throws IOException {
        DistrictWiseData cResponse = new DistrictWiseData();
        String Url = env.getProperty("corona.statewise.data");
        if(null != Url) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<DistrictWiseData> entity = new HttpEntity<>(headers);
            ResponseEntity<DistrictWiseData> response = restTemplate.exchange(Url,
                    HttpMethod.GET, entity, DistrictWiseData.class);
            logger.info("Response Corona Data ::" + response.getBody());
            //ResponseEntity<String> response = restTemplate.getForEntity(Url, Object.class);
            if(null != response.getBody()) {
                cResponse = response.getBody();
            }
        }
        return cResponse;
    }

    public CoronaCountryResponse countryWise() throws IOException {
        CoronaCountryResponse cResponse = new CoronaCountryResponse();
        String Url = env.getProperty("data.national");
        if(null != Url) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CoronaCountryResponse> entity = new HttpEntity<>(headers);
            ResponseEntity<CoronaCountryResponse> response = restTemplate.exchange(Url,
                    HttpMethod.GET, entity, CoronaCountryResponse.class);
            logger.info("Response Corona country Data ::" + response.getBody());
            //ResponseEntity<String> response = restTemplate.getForEntity(Url, Object.class);
            if(null != response.getBody()) {
                cResponse = response.getBody();
            }
        }
        return cResponse;
    }


}
