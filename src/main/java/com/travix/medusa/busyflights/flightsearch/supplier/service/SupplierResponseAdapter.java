package com.travix.medusa.busyflights.flightsearch.supplier.service;

import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;

public interface SupplierResponseAdapter {

    FlightInfoElement convert(SupplierFlightInfoElement supplierFlightInfoElements);

}
