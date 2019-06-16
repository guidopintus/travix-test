package com.travix.medusa.busyflights.flightsearch.supplier.crazyair;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyAirClient implements SupplierClient {
    @Override
    public List<SupplierFlightInfoElement> requestFlights(SupplierFlightQuery query) {
        List<SupplierFlightInfoElement> list=new ArrayList<>();
        CrazyAirResponse elem=new CrazyAirResponse();


        list.add(elem);
        return list;
    }
}
