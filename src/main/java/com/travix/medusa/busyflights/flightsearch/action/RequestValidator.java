package com.travix.medusa.busyflights.flightsearch.action;


import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;


public interface RequestValidator {

    Boolean validate(BusyFlightsRequest request);

}
