package com.travix.medusa.busyflights.flightsearch.model;

import java.util.Objects;

public class FlightInfoElement {

    private final String airline;
    private final String supplied;
    private final double fare;
    private final String departureAirportCode;
    private final String destinationAirportCode;
    private final String departureDate;
    private final String arrivalDate;

    public FlightInfoElement(String airline, String supplied, double fare, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.supplied = supplied;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getSupplied() {
        return supplied;
    }

    public double getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightInfoElement)) return false;
        FlightInfoElement that = (FlightInfoElement) o;
        return Double.compare(that.fare, fare) == 0 &&
                airline.equals(that.airline) &&
                supplied.equals(that.supplied) &&
                departureAirportCode.equals(that.departureAirportCode) &&
                destinationAirportCode.equals(that.destinationAirportCode) &&
                departureDate.equals(that.departureDate) &&
                arrivalDate.equals(that.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, supplied, fare, departureAirportCode, destinationAirportCode, departureDate, arrivalDate);
    }
}
