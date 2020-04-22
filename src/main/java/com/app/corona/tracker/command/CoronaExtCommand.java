package com.app.corona.tracker.command;

import com.app.corona.tracker.resposne.CoronaCountryResponse;
import com.app.corona.tracker.resposne.DistrictWiseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoronaExtCommand {

    private static final Logger logger = LoggerFactory.getLogger(CoronaExtCommand.class);

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    public List<DistrictWiseData> coronaCasesByAllState() throws IOException {
        logger.info("Entering CoronaExtCommand :: coronaCasesByAllState() method");
        List<DistrictWiseData> districtWiseData = new ArrayList<>();
        String Url = env.getProperty("corona.statewise.data");
        if(null != Url) {
            DistrictWiseData[] list = restTemplate.getForObject(Url, DistrictWiseData[].class);
            logger.info("Response Corona Data ::" + list);
            if(null != list) {
                districtWiseData = Arrays.stream(list).collect(Collectors.toList());
            }
        }
        logger.info("Exiting CoronaExtCommand :: coronaCasesByAllState() method");
        return districtWiseData;
    }

    public CoronaCountryResponse countryWise() throws IOException {
        logger.info("Entering CoronaExtCommand :: countryWise() method");
        CoronaCountryResponse cResponse = new CoronaCountryResponse();
        String Url = env.getProperty("data.national");
        if(null != Url) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CoronaCountryResponse> entity = new HttpEntity<>(headers);
            ResponseEntity<CoronaCountryResponse> response = restTemplate.exchange(Url,
                    HttpMethod.GET, entity, CoronaCountryResponse.class);
            logger.info("Response Corona country Data ::" + response.getBody());
            if(null != response.getBody()) {
                cResponse = response.getBody();
            }
        }
        logger.info("Exiting CoronaExtCommand :: countryWise() method");
        return cResponse;
    }


}
