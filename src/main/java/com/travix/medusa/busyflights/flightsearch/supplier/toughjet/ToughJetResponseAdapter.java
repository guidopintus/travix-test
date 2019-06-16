package com.travix.medusa.busyflights.flightsearch.supplier.toughjet;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierResponseAdapter;
import org.springframework.stereotype.Service;

@Service
public class ToughJetResponseAdapter implements SupplierResponseAdapter {

    private static final String supplier="Toughjet";

    @Override
    public FlightInfoElement convert(SupplierFlightInfoElement supplierFlightInfoElement) {

        ToughJetResponse response= (ToughJetResponse) supplierFlightInfoElement;
        Double fare=response.getBasePrice()+response.getTax()-response.getDiscount();
        String airline=response.getCarrier();
        String departureAirportCode=response.getDepartureAirportName();
        String destinationAirportCode=response.getArrivalAirportName();
        String departureDate=response.getInboundDateTime();
        String arrivalDate=response.getOutboundDateTime();


        return new FlightInfoElement(airline,
                supplier,
                fare,
                departureAirportCode,
                destinationAirportCode,
                departureDate,
                arrivalDate);
    }
}
