package main.java.com.offer.dao;

import main.java.com.offer.domain.Booking;
import main.java.com.offer.domain.Payment;

public interface PaymentDao {
    Payment makePayment(Booking booking);
}
