package com.app.corona.tracker.controller;


import com.app.corona.tracker.resposne.CoronaResponse;
import com.app.corona.tracker.service.CoronaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/coronaTracker")
public class CoronaController {
    private static final Logger logger = LoggerFactory.getLogger(CoronaController.class);

    @Autowired
    CoronaService coronaService;

    @ApiOperation(value = "Populate StateWise and District Wise CoVID19 Cases", produces = "application/json")
    @GetMapping("/stateAndDistrictWiseCoronaCases")
    public ResponseEntity<CoronaResponse> getAllStateCorona(HttpServletRequest httpServletRequest) {
        logger.info("Entering CustomerController :: getAllStateCorona()");
        CoronaResponse obj = coronaService.getAllStateCases(httpServletRequest);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
