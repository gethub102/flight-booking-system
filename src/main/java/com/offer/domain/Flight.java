package main.java.com.offer.domain;


import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private int flightNumber;
    private String flightName;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private String destination;
    private int airplaneId;
    private String departureCity;
    private String arrivalCity;

    public Flight() {
    }

    public Flight(String flightName, LocalTime arrivalTime, LocalDate arrivalDate, LocalTime departureTime, LocalDate departureDate, String destination, int airplaneId, String departureCity, String arrivalCity) {
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.destination = destination;
        this.airplaneId = airplaneId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplanId) {
        this.airplaneId = airplanId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}
