package main.java.com.offer.service;

import main.java.com.offer.dao.FlightDao;
import main.java.com.offer.dao.FlightDaoImpl;
import main.java.com.offer.domain.Flight;

import java.util.List;

public class RetrieveFlightImpl implements RetrieveFlight {

    @Override
    public List<Flight> retrieveFlights() {
        FlightDao flightDao = new FlightDaoImpl();
        return flightDao.retrieveFlights();
    }
}
