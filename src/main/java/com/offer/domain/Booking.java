package main.java.com.offer.domain;

public class Booking {
    private int bookingId;
    private int passengerId;
    private int flightNumber;
    private int seatNumber;
    private String baggage;
    private String classtype;
    private String status;

    public Booking() {
    }

    public Booking(int passengerId, int seatNumber, String baggage, String classtype, String status) {

        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
        this.baggage = baggage;
        this.classtype = classtype;
        this.status = status;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getBookingId() {

        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
