package com.travix.medusa.busyflights.flightsearch.supplier.toughjet;

import com.travix.medusa.busyflights.flightsearch.supplier.AbstractSupplierFlightFinder;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierClient;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierRequestAdapter;
import com.travix.medusa.busyflights.flightsearch.supplier.service.SupplierResponseAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ToughJetFlightFinder extends AbstractSupplierFlightFinder {

    public ToughJetFlightFinder(@Qualifier("toughJetRequestAdapter") SupplierRequestAdapter requestAdapter,
                                @Qualifier("toughJetClient") SupplierClient client,
                                @Qualifier("toughJetResponseAdapter") SupplierResponseAdapter responseAdapter) {
        super(requestAdapter, client, responseAdapter);
    }
}
