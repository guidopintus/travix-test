package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightSearchResponseBuilder implements ResponseBuilder {

    List<FlightInfoElement> infoElements;

    public BusyFlightsResponse build() {
        return new BusyFlightsResponse(infoElements);
    }

    public FlightSearchResponseBuilder addFlights(List<FlightInfoElement> infoElements) {
        this.infoElements=infoElements
                .stream()
                .sorted(Comparator.comparingDouble(FlightInfoElement::getFare))
                .collect(Collectors.toList());
        return this;
    }


}
