package com.travix.medusa.busyflights.flightsearch.supplier.crazyair;

import com.travix.medusa.busyflights.flightsearch.supplier.AbstractSupplierFlightFinder;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierRequestAdapter;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierResponseAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CrazyAirFlightFinder extends AbstractSupplierFlightFinder {
    public CrazyAirFlightFinder(@Qualifier("crazyAirRequestAdapter") SupplierRequestAdapter requestAdapter,
                                @Qualifier("crazyAirClient") SupplierClient client,
                                @Qualifier("crazyAirResponseAdapter") SupplierResponseAdapter responseAdapter) {
        super(requestAdapter, client, responseAdapter);
    }
}
