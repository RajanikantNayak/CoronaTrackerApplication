package com.app.corona.tracker.controller;

import com.app.corona.tracker.Application;
import com.app.corona.tracker.command.CoronaExtCommand;
import com.app.corona.tracker.resposne.CoronaCountryResponse;
import com.app.corona.tracker.resposne.CoronaResponse;
import com.app.corona.tracker.resposne.DistrictWiseData;
import com.app.corona.tracker.serviceImpl.CoronaServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class CoronaControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private CoronaExtCommand coronaExtCommand;

    @InjectMocks
    CoronaServiceImpl coronaService;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getAllStateCoronaTest() throws Exception {

        CoronaResponse res = new CoronaResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        CoronaCountryResponse coronaCountryResponse = new CoronaCountryResponse();
        File file = ResourceUtils.getFile("classpath:data.json");
        coronaCountryResponse = mapper.readValue(file, CoronaCountryResponse.class );
        Mockito.when(coronaExtCommand.countryWise()).thenReturn(coronaCountryResponse);

        File file1 = ResourceUtils.getFile("classpath:statedistrictwise.json");
        DistrictWiseData[] list = mapper.readValue(file1, DistrictWiseData[].class );
        List<DistrictWiseData> districtWiseData  = Arrays.stream(list).collect(Collectors.toList());
        Mockito.when(coronaExtCommand.coronaCasesByAllState()).thenReturn(districtWiseData);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/coronaTracker/stateAndDistrictWiseCoronaCases").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
    }

}
