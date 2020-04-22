package com.app.corona.tracker.serviceImpl;

import com.app.corona.tracker.command.CoronaExtCommand;
import com.app.corona.tracker.resposne.*;
import com.app.corona.tracker.service.CoronaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoronaServiceImpl implements CoronaService {

    private static final Logger logger = LoggerFactory.getLogger(CoronaServiceImpl.class);
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM");

    @Autowired
    CoronaExtCommand coronaExtCommand;

    @Override
    public CoronaResponse getAllStateCases(HttpServletRequest request) {
        logger.info("Entering CoronaServiceImpl :: getAllStateCases() method");
        CoronaResponse response = new CoronaResponse();
        try{
            List<StateWiseData> stateWise = new ArrayList<>();
            CoronaCountryResponse coronaCountryResponse = coronaExtCommand.countryWise();
            if(null != coronaCountryResponse) {
                List<DistrictWiseData> districtWiseDataList = coronaExtCommand.coronaCasesByAllState();
                List<CasesTimeSeries> list = coronaCountryResponse.getCases_time_series();
                Collections.sort(list, (CasesTimeSeries a, CasesTimeSeries b) -> {
                    try {
                        return format.parse(b.getDate()).
                                compareTo(format.parse(a.getDate()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                });
                logger.info("After Sorting ::" + list.toString());
                CasesTimeSeries casesTimeSeries = list.get(0);
                response.setConfirmed(casesTimeSeries.getTotalconfirmed());
                response.setDeceased(casesTimeSeries.getTotaldeceased());
                response.setRecovered(casesTimeSeries.getTotalrecovered());
                response.setLastUpdateDate(casesTimeSeries.getDate());
                coronaCountryResponse.getStatewise().stream().forEach(state -> {
                    StateWiseData stateWiseData = new StateWiseData();
                    stateWiseData.setStateName(state.getState());
                    stateWiseData.setConfirmed(state.getConfirmed());
                    stateWiseData.setActive(state.getActive());
                    stateWiseData.setDeceased(state.getDeaths());
                    stateWiseData.setRecovered(state.getRecovered());
                    List<DistrictDataVo> districtDataVoList = getDistrictsByState(state.getState(), districtWiseDataList);
                    stateWiseData.setDistrictDataVoList((null != districtDataVoList ? districtDataVoList : new ArrayList<DistrictDataVo>() ));
                    stateWise.add(stateWiseData);
                });
                response.setStateWise(stateWise);
            }
        }catch(Exception ee){
            logger.error("Error in calling COVID api" + ee.getMessage());
        }
        logger.info("Exiting CoronaServiceImpl :: getAllStateCases() method");
        return response;
    }

    List<DistrictDataVo> getDistrictsByState(String state, List<DistrictWiseData> districtWiseDataList) {
        logger.info("State value::{}", state);
        List<DistrictDataVo> districtDataVoList = new ArrayList<>();
        if(null != state && null != districtWiseDataList) {
            for(DistrictWiseData districtWiseData : districtWiseDataList) {
                if(state.equalsIgnoreCase(districtWiseData.getState())) {
                    districtDataVoList = districtWiseData.getDistrictData().stream().map( dist -> {
                        DistrictDataVo districtDataVo = new DistrictDataVo();
                        districtDataVo.setDistrictName(dist.getDistrict());
                        districtDataVo.setConfirmed(dist.getConfirmed());
                        districtDataVo.setActive(dist.getActive());
                        districtDataVo.setDeceased(dist.getDeceased());
                        districtDataVo.setRecovered(dist.getDeceased());
                        return districtDataVo;
                    }).collect(Collectors.toList());

                }
            }
        }
        return districtDataVoList;
    }
}
