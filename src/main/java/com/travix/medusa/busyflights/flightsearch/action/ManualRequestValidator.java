package com.travix.medusa.busyflights.flightsearch.action;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import org.springframework.stereotype.Service;

@Service
public class ManualRequestValidator implements RequestValidator {
    @Override
    public Boolean validate(BusyFlightsRequest request) {
        return true;
    }
}
