package main.java.com.offer.service;


import main.java.com.offer.dao.AdminDao;
import main.java.com.offer.dao.AdminDaoImpl;
import main.java.com.offer.dao.PassengerDao;
import main.java.com.offer.dao.PassengerDaoImpl;
import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

public class UpdateProfileServiceImpl implements UpdateProfileService {
    @Override
    public Passenger updateProfile(Passenger passenger) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        return passengerDao.updateProfile(passenger);
    }

    @Override
    public Admin updateProfile(Admin admin) {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.updateProfile(admin);
    }
}
