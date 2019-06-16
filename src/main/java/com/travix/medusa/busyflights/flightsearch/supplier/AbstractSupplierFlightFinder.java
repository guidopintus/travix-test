package com.travix.medusa.busyflights.flightsearch.supplier;

import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;
import com.travix.medusa.busyflights.flightsearch.aggregator.FlightSearchQuery;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightInfoElement;
import com.travix.medusa.busyflights.domain.supplier.SupplierFlightQuery;
import com.travix.medusa.busyflights.flightsearch.FlightFinder;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierRequestAdapter;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierResponseAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AbstractSupplierFlightFinder implements FlightFinder {

    protected final SupplierRequestAdapter requestAdapter;
    protected final SupplierClient client;
    protected final SupplierResponseAdapter responseAdapter;

    public AbstractSupplierFlightFinder(SupplierRequestAdapter requestAdapter, SupplierClient client, SupplierResponseAdapter responseAdapter) {
        this.requestAdapter = requestAdapter;
        this.client = client;
        this.responseAdapter = responseAdapter;
    }


    @Override
    public List<FlightInfoElement> search(FlightSearchQuery searchQuery) {

        SupplierFlightQuery supplierFlightQuery=requestAdapter.convert(searchQuery);
        List<SupplierFlightInfoElement> supplierFlights=client.requestFlights(supplierFlightQuery);

        List<FlightInfoElement> flightInfoElements=new ArrayList<>();

        for(SupplierFlightInfoElement supplierFlight: supplierFlights){
            flightInfoElements.add(responseAdapter.convert(supplierFlight));
        }

        return flightInfoElements;
    }
}
