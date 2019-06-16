package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.InvalidInputException;
import com.travix.medusa.busyflights.flightsearch.FlightFinder;
import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateAndSearch implements SearchFlightsAction {

    @Autowired
    RequestValidator requestValidator;

    @Autowired
    @Qualifier("aggregatorFlightFinder")
    FlightFinder finder;

    @Autowired
    ResponseBuilder responseBuilder;

    @Override
    public BusyFlightsResponse execute(BusyFlightsRequest request) throws InvalidInputException {
        if (!requestValidator.validate(request)) {
            throw new InvalidInputException();
        }

        FlightSearchQuery query = new FlightSearchQuery(request.getOrigin()
                , request.getDestination()
                , request.getDepartureDate()
                , request.getReturnDate()
                , request.getNumberOfPassengers());

        List<FlightInfoElement> flights = finder.search(query);

        return responseBuilder.addFlights(flights).build();
    }
}
