package com.travix.medusa.busyflights.flightsearch.aggregator;

import java.util.Objects;

public class FlightSearchQuery {

    private final String origin;
    private final String destination;
    private final String departureDate;
    private final String returnDate;
    private final int numberOfPassengers;

    public FlightSearchQuery(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightSearchQuery)) return false;
        FlightSearchQuery that = (FlightSearchQuery) o;
        return numberOfPassengers == that.numberOfPassengers &&
                origin.equals(that.origin) &&
                destination.equals(that.destination) &&
                departureDate.equals(that.departureDate) &&
                returnDate.equals(that.returnDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, departureDate, returnDate, numberOfPassengers);
    }
}
