package com.offer.service;

import com.offer.dao.PassengerDao;
import com.offer.dao.PassengerDaoImpl;
import com.offer.domain.Passenger;

public class AutheServiceImpl implements AuthService {
    @Override
    public Passenger login(Passenger passenger) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Passenger passengerBean = passengerDao.login(passenger);
        return passengerBean;
    }
}
