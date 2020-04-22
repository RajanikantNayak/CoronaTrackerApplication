package com.app.corona.tracker.service;

import com.app.corona.tracker.resposne.CoronaResponse;

import javax.servlet.http.HttpServletRequest;

public interface CoronaService {

    CoronaResponse getAllStateCases(HttpServletRequest request);
}
