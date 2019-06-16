package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;

import java.util.List;

public interface ResponseBuilder {

    BusyFlightsResponse build();

    FlightSearchResponseBuilder addFlights(List<FlightInfoElement> infoElements);

}
