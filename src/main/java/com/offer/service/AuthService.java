package main.java.com.offer.service;


import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

public interface AuthService {
    Passenger login(Passenger passenger);
    Passenger register(Passenger passenger);
    Admin adminLogin(Admin admin);
}
