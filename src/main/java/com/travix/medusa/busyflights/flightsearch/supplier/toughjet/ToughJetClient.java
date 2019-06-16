package com.travix.medusa.busyflights.flightsearch.supplier.toughjet;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToughJetClient implements SupplierClient {
    @Override
    public List<SupplierFlightInfoElement> requestFlights(SupplierFlightQuery query) {

        List<SupplierFlightInfoElement> list=new ArrayList<>();
        ToughJetResponse elem=new ToughJetResponse();

        elem.setDepartureAirportName("PIS");
        elem.setArrivalAirportName("CAG");
        elem.setBasePrice(12);
        elem.setCarrier("Ryanair");
        elem.setDiscount(1);
        elem.setTax(4);
        elem.setInboundDateTime(LocalDateTime.now().plusDays(2).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        elem.setOutboundDateTime(LocalDateTime.now().plusDays(2).plusHours(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        list.add(elem);
        return list;
    }
}
