package com.travix.medusa.busyflights.flightsearch.supplier.service;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;

import java.util.List;

public interface SupplierClient {

    List<SupplierFlightInfoElement> requestFlights(SupplierFlightQuery query);

}
