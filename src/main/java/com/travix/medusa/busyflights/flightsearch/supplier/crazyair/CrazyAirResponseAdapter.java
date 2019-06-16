package com.travix.medusa.busyflights.flightsearch.supplier.crazyair;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierResponseAdapter;
import org.springframework.stereotype.Service;

@Service
public class CrazyAirResponseAdapter implements SupplierResponseAdapter {

    private static final String supplier="Crazyair";

    @Override
    public FlightInfoElement convert(SupplierFlightInfoElement supplierFlightInfoElement) {

        CrazyAirResponse response= (CrazyAirResponse) supplierFlightInfoElement;
        Double fare=response.getPrice();
        String airline=response.getAirline();
        String departureAirportCode=response.getDepartureAirportCode();
        String destinationAirportCode=response.getDestinationAirportCode();
        String departureDate=response.getDepartureDate();
        String arrivalDate=response.getArrivalDate();

        return new FlightInfoElement(airline,
                supplier,
                fare,
                departureAirportCode,
                destinationAirportCode,
                departureDate,
                arrivalDate);
    }
}
