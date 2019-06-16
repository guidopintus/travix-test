package com.travix.medusa.busyflights.flightsearch.supplier.crazyair;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyAirClient implements SupplierClient {
    @Override
    public List<SupplierFlightInfoElement> requestFlights(SupplierFlightQuery query) {
        List<SupplierFlightInfoElement> list=new ArrayList<>();
        CrazyAirResponse elem=new CrazyAirResponse();

        elem.setAirline("Alitalia");
        elem.setPrice(30);
        elem.setCabinclass("E");
        elem.setDepartureAirportCode("CAG");
        elem.setDestinationAirportCode("PIS");
        elem.setDepartureDate(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        elem.setArrivalDate(LocalDateTime.now().plusDays(1).plusHours(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        list.add(elem);
        return list;
    }
}
