package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.InvalidInputException;
import com.travix.medusa.busyflights.flightsearch.action.SearchFlightsAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/search")
public class BusyFlightsController {


    @Autowired
    @Qualifier("validateAndSearch")
    private SearchFlightsAction searchFlightsAction;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BusyFlightsResponse search(BusyFlightsRequest request) throws InvalidInputException {
        return searchFlightsAction.execute(request);

    }

}
