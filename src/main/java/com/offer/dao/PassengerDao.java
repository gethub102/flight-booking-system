package main.java.com.offer.dao;


import main.java.com.offer.domain.Passenger;

public interface PassengerDao {
    Passenger login(Passenger passenger);
    Passenger register(Passenger passenger);
    Passenger updateProfile(Passenger passenger);
}
