package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.InvalidInputException;


public interface SearchFlightsAction {

    BusyFlightsResponse execute(BusyFlightsRequest request) throws InvalidInputException;

}
