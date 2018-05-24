package main.java.com.offer.service;


import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

public interface UpdateProfileService {
    Passenger updateProfile(Passenger passenger);
    Admin updateAdminProfile(Admin admin);
}
