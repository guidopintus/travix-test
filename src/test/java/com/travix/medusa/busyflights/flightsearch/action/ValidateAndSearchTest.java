package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.InvalidInputException;
import com.travix.medusa.busyflights.flightsearch.FlightFinder;
import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateAndSearchTest {

    @MockBean
    RequestValidator validator;

    @MockBean
    @Qualifier("aggregatorFlightFinder")
    FlightFinder finder;

    @MockBean
    FlightSearchResponseBuilder responseBuilder;


    @Autowired
    @Qualifier("validateAndSearch")
    SearchFlightsAction action;

    BusyFlightsRequest request;
    BusyFlightsResponse response;
    FlightSearchQuery query;

    @Before
    public void before() {
        request = new BusyFlightsRequest();
        List<FlightInfoElement> flightInfoElements = new ArrayList<>();
        response = new BusyFlightsResponse(flightInfoElements);
        query = new FlightSearchQuery("", "", "", "", 3);
    }


    @Test
    public void givenPassedValidation_assertReturnedResponse() throws InvalidInputException {
        given(validator.validate(request)).willReturn(true);
        given(finder.search(query)).willReturn(new ArrayList<>());
        given(responseBuilder.addFlights(new ArrayList<>())).willReturn(responseBuilder);
        given(responseBuilder.build()).willReturn(response);
        BusyFlightsResponse res = action.execute(request);
        Assert.assertEquals(response, res);
    }

    @Test(expected = InvalidInputException.class)
    public void givenInvalidInputResponse_throwException() throws InvalidInputException {
        given(validator.validate(request)).willReturn(false);
        given(responseBuilder.build()).willReturn(response);
        action.execute(request);
    }
}