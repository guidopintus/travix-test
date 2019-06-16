package com.travix.medusa.busyflights.flightsearch.aggregator;

import com.travix.medusa.busyflights.flightsearch.FlightFinder;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import com.travix.medusa.busyflights.flightsearch.supplier.AbstractSupplierFlightFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregatorFlightFinder implements FlightFinder {


    @Autowired(required = false)
    List<AbstractSupplierFlightFinder> flightFinders;

    @Override
    public List<FlightInfoElement> search(FlightSearchQuery searchQuery) {
        List<FlightInfoElement> flights = new ArrayList<>();
        if (flightFinders != null) {

            for (AbstractSupplierFlightFinder supplierFlightFinder : flightFinders) {
                flights.addAll(supplierFlightFinder.search(searchQuery));
            }
        }
        return flights;

    }

}
