package com.offer.service;

import com.offer.dao.PassengerDao;
import com.offer.dao.PassengerDaoImpl;
import com.offer.domain.Passenger;

public class UpdateProfileServiceImpl implements UpdateProfileService {
    @Override
    public Passenger updateProfile(Passenger passenger) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        return passengerDao.updateProfile(passenger);
    }
}
