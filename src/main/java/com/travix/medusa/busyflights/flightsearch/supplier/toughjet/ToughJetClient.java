package com.travix.medusa.busyflights.flightsearch.supplier.toughjet;

import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToughJetClient implements SupplierClient {
    @Override
    public List<SupplierFlightInfoElement> requestFlights(SupplierFlightQuery query) {

        List<SupplierFlightInfoElement> list=new ArrayList<>();
        ToughJetResponse elem=new ToughJetResponse();
        list.add(elem);
        return list;
    }
}
