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

@Service
public class CoronaServiceImpl implements CoronaService {

    private static final Logger logger = LoggerFactory.getLogger(CoronaServiceImpl.class);
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM");

    @Autowired
    CoronaExtCommand coronaExtCommand;

    @Override
    public CoronaResponse getAllStateCases(HttpServletRequest request) {
        CoronaResponse response = new CoronaResponse();
        try{
            List<StateWiseData> stateWise = new ArrayList<>();
            CoronaCountryResponse coronaCountryResponse = coronaExtCommand.countryWise();
            if(null != coronaCountryResponse) {

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
                    List<DistrictDataVo> districtDataVoList = getDistrictsByState(state.getStatecode());
                    stateWiseData.setDistrictDataVoList((null != districtDataVoList ? districtDataVoList : new ArrayList<DistrictDataVo>() ));
                    stateWise.add(stateWiseData);
                });
                response.setStateWise(stateWise);
            }
        }catch(Exception ee){
            logger.error("Error in calling COVID api" + ee.getMessage());
        }
        return response;
    }

    List<DistrictDataVo> getDistrictsByState(String state) {
        List<DistrictDataVo> districtDataVoList = new ArrayList<>();
        try {
            DistrictWiseData districtWiseData = coronaExtCommand.coronaCasesByAllState();
            switch (state) {
                case "AN":
                    DistrictDataVo districtDataVo =  new DistrictDataVo();
                    districtDataVo.setDistrictName("North and Middle Andaman");
                    districtDataVo.setActive(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getNorthandMiddleAndaman().getActive());
                    districtDataVo.setConfirmed(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getNorthandMiddleAndaman().getConfirmed());
                    districtDataVo.setDeceased(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getNorthandMiddleAndaman().getDeceased());
                    districtDataVo.setRecovered(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getNorthandMiddleAndaman().getRecovered());
                    districtDataVoList.add(districtDataVo);

                    DistrictDataVo districtDataVo1=  new DistrictDataVo();
                    districtDataVo1.setDistrictName("South Andaman");
                    districtDataVo1.setActive(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getSouthAndaman().getActive());
                    districtDataVo1.setConfirmed(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getSouthAndaman().getConfirmed());
                    districtDataVo1.setDeceased(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getSouthAndaman().getDeceased());
                    districtDataVo1.setRecovered(districtWiseData.getAndamanandNicobarIslands().getDistrictData().getSouthAndaman().getRecovered());
                    districtDataVoList.add(districtDataVo1);
                    break;
                default:
                    return districtDataVoList;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districtDataVoList;
    }
}
