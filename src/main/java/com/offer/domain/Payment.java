package main.java.com.offer.domain;

import java.sql.Timestamp;

public class Payment {
    private int paymentId;
    private int bookingId;
    private double paymentAmmount;
    private Timestamp paymentDate;

    public Payment() {
    }

    public Payment(int bookingId, double paymentAmmount, Timestamp paymentDate) {

        this.bookingId = bookingId;
        this.paymentAmmount = paymentAmmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getPaymentAmmount() {
        return paymentAmmount;
    }

    public void setPaymentAmmount(double paymentAmmount) {
        this.paymentAmmount = paymentAmmount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }
}
