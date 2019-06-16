package com.travix.medusa.busyflights.flightsearch.supplier.service;

import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;

public interface SupplierRequestAdapter {

    SupplierFlightQuery convert(FlightSearchQuery query);

}
