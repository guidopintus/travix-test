package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.flightsearch.model.FlightInfoElement;

import java.util.List;
import java.util.Objects;

public class BusyFlightsResponse {

    private final List<FlightInfoElement> list;

    public BusyFlightsResponse(List<FlightInfoElement> list) {
        this.list = list;
    }

    public List<FlightInfoElement> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusyFlightsResponse)) return false;
        BusyFlightsResponse that = (BusyFlightsResponse) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
