package com.offer.dao;

import com.offer.domain.Passenger;

public interface PassengerDao {
    Passenger login(Passenger passenger);
    Passenger updateProfile(Passenger passenger);
}
