package main.java.com.offer.dao;

import main.java.com.offer.db.DBUtil;
import main.java.com.offer.domain.Booking;
import main.java.com.offer.domain.Flight;
import main.java.com.offer.domain.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao {

    FlightDao flightDao = new FlightDaoImpl();

    @Override
    public Payment makePayment(Booking booking) {
        Payment payment = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement ps = null;
        int ret = 0;

        try {

            connection = DBUtil.getConnection();
            Flight flight = flightDao.orderTicket(booking.getFlightNumber(), booking.getClasstype());

            int seatNum = 0;
            switch (booking.getClasstype()) {
                case "classA":
                    seatNum = flight.getClassA();
                    break;
                case "classB":
                    seatNum = flight.getClassB();
                    break;
                case "classC":
                    seatNum = flight.getClassC();
                    break;
            }

            String query = "INSERT INTO Booking (passengerId, flightNumber, seatNumber, baggage, class) VALUES (?, ?, ?, ?, ?); ";
            preparedStatement = connection.prepareStatement(query);
            booking.setStatus("booked");
            preparedStatement.setInt(1, booking.getPassengerId());
            preparedStatement.setInt(2, booking.getFlightNumber());
            preparedStatement.setInt(3, seatNum);
            preparedStatement.setString(4, booking.getBaggage());
            preparedStatement.setString(5, booking.getClasstype());
            if (preparedStatement.executeUpdate() == 0) {
                return payment;
            }

            // to get class type price
            // to get the paymetn amount

            double paymentAmmount = 0;
            switch (booking.getClasstype()) {
                case "classA":
                    paymentAmmount = flight.getClassAPirce();
                    break;
                case "classB":
                    paymentAmmount = flight.getClassBPirce();
                    break;
                case "classC":
                    paymentAmmount = flight.getClassCPirce();
                    break;
            }
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            String payment_insertion = "INSERT INTO Payment(bookingId, paymentAmmount, paymentDate) VALUES (?, ?, ?); ";
            ps = connection.prepareStatement(payment_insertion);
            ps.setInt(1, booking.getBookingId());
            ps.setDouble(2, paymentAmmount);
            ps.setTimestamp(3, timestamp);
            ret = ps.executeUpdate();
            if (ret != 0) {
                payment = new Payment(booking.getBookingId(), paymentAmmount, timestamp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(connection, preparedStatement);
            DBUtil.closeDbResources(connection, ps);
        }

        return payment;

    }
}
