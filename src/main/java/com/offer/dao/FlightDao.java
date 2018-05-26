package main.java.com.offer.dao;

import main.java.com.offer.domain.Flight;

import java.util.List;

public interface FlightDao {
    Flight addFlight(Flight flight);

    List<Flight> retrieveFlights();

    Flight retrieveFlight(int id);

    Flight orderTicket(int id, String type);
}
