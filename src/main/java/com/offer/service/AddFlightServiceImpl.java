package main.java.com.offer.service;

import main.java.com.offer.dao.FlightDao;
import main.java.com.offer.dao.FlightDaoImpl;
import main.java.com.offer.domain.Flight;

public class AddFlightServiceImpl implements AddFlightService {

    @Override
    public Flight addFlight(Flight flight) {
        FlightDao flightDao = new FlightDaoImpl();
        return flightDao.addFlight(flight);
    }
}
