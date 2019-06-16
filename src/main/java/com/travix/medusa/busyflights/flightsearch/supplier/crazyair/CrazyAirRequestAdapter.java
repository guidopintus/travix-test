package com.travix.medusa.busyflights.flightsearch.supplier.crazyair;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierRequestAdapter;
import org.springframework.stereotype.Service;

@Service
public class CrazyAirRequestAdapter implements SupplierRequestAdapter {
    @Override
    public SupplierFlightQuery convert(FlightSearchQuery query)
    {
        CrazyAirRequest request=new CrazyAirRequest();
        request.setDepartureDate(query.getDepartureDate());
        request.setReturnDate(query.getReturnDate());
        request.setOrigin(query.getOrigin());
        request.setDestination(query.getDestination());
        request.setPassengerCount(query.getNumberOfPassengers());
        return new CrazyAirRequest();
    }
}
