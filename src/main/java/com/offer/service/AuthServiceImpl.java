package main.java.com.offer.service;


import main.java.com.offer.dao.AdminDao;
import main.java.com.offer.dao.AdminDaoImpl;
import main.java.com.offer.dao.PassengerDao;
import main.java.com.offer.dao.PassengerDaoImpl;
import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

public class AuthServiceImpl implements AuthService {
    @Override
    public Passenger login(Passenger passenger) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Passenger passengerBean = passengerDao.login(passenger);
        return passengerBean;
    }

    @Override
    public Passenger register(Passenger passenger) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Passenger passengerBean = passengerDao.register(passenger);
        return passengerBean;
    }

    @Override
    public Admin adminLogin(Admin admin) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin adminBean = adminDao.login(admin);
        return adminBean;
    }
}
