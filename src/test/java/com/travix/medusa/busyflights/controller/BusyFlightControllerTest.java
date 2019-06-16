package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.InvalidInputException;
import com.travix.medusa.busyflights.flightsearch.action.SearchFlightsAction;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BusyFlightsController.class)
public class BusyFlightControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchFlightsAction action;

    BusyFlightsRequest request;
    BusyFlightsResponse response;

    @Before
    public void before() {
        request = new BusyFlightsRequest();
        List<FlightInfoElement> flightInfoElements = new ArrayList<>();
        response = new BusyFlightsResponse(flightInfoElements);
    }


    @Test
    public void testSearchController() throws Exception, InvalidInputException {

        given(action.execute(request)).willReturn(response);

        mvc.perform(post("/api/search").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void givenInvalidRequestException_throwInvalidRequestException() throws Exception, InvalidInputException {
        given(action.execute(request)).willThrow(new InvalidInputException());

        mvc.perform(post("/api/search").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

}
