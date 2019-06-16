package com.travix.medusa.busyflights.flightsearch;

import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;

import java.util.List;

public interface FlightFinder {

    List<FlightInfoElement> search(FlightSearchQuery searchQuery);

}
