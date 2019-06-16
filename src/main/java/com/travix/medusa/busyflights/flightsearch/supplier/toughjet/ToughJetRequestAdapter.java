package com.travix.medusa.busyflights.flightsearch.supplier.toughjet;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierRequestAdapter;
import org.springframework.stereotype.Service;

@Service
public class ToughJetRequestAdapter implements SupplierRequestAdapter {
    @Override
    public SupplierFlightQuery convert(FlightSearchQuery query) {
        ToughJetRequest request=new ToughJetRequest();
        request.setFrom(query.getOrigin());
        request.setTo(query.getDestination());
        request.setInboundDate(query.getDepartureDate());
        request.setOutboundDate(query.getReturnDate());
        request.setNumberOfAdults(query.getNumberOfPassengers());

        return request;
    }
}
