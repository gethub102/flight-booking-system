package main.java.com.offer.dao;

import main.java.com.offer.db.DBUtil;
import main.java.com.offer.domain.Flight;
import main.java.com.offer.domain.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {
    @Override
    public Flight addFlight(Flight flight) {
        Flight retFlight = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int queryResult = 0;
        try {
            connection = DBUtil.getConnection();
            String addFlightQuery = "INSERT INTO Flight (flightName, arrivalTime, arrivalDate, departureTime, departureDate, destination, airplaneId, departureCity, arrivalCity, classA, classB, classC) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
            preparedStatement = connection.prepareStatement(addFlightQuery);
            preparedStatement.setString(1, flight.getFlightName());
            preparedStatement.setString(2, flight.getArrivalTime());
            preparedStatement.setString(3, flight.getArrivalDate());
            preparedStatement.setString(4, flight.getDepartureTime());
            preparedStatement.setString(5, flight.getDepartureDate());
            preparedStatement.setString(6, flight.getDestination());
            preparedStatement.setInt(7, flight.getAirplaneId());
            preparedStatement.setString(8, flight.getDepartureCity());
            preparedStatement.setString(9, flight.getArrivalCity());
            preparedStatement.setInt(10, flight.getClassA());
            preparedStatement.setInt(11, flight.getClassB());
            preparedStatement.setInt(12, flight.getClassC());
            System.out.println(preparedStatement.toString());
            queryResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        if (queryResult != 0) {
            retFlight = flight;
        }
        return retFlight;
    }

    @Override
    public List<Flight> retrieveFlights() {
        List<Flight> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM Flight; ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int flightNumber = resultSet.getInt("flightNumber");
                String flightName = resultSet.getString("flightName");
                String arrivalTime = resultSet.getString("arrivalTime");
                String arrivalDate = resultSet.getString("arrivalDate");
                String departureTime = resultSet.getString("departureTime");
                String departureDate = resultSet.getString("departureDate");
                String destination = resultSet.getString("destination");
                int airplaneId = resultSet.getInt("airplaneId");
                String departureCity = resultSet.getString("departureCity");
                String arrivalCity = resultSet.getString("arrivalCity");
                int classA = resultSet.getInt("classA");
                int classB = resultSet.getInt("classB");
                int classC = resultSet.getInt("classC");
                double classAPirce = resultSet.getDouble("classAPirce");
                double classBPirce = resultSet.getDouble("classBPirce");
                double classCPirce = resultSet.getDouble("classCPirce");
                System.out.println("time = " + arrivalTime + " : " + " date = " + arrivalDate);
                Flight flight = new Flight(flightNumber, flightName, arrivalTime, arrivalDate, departureTime, departureDate, destination, airplaneId, arrivalCity, departureCity, classA, classB, classC, classAPirce, classBPirce, classCPirce);
                list.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public Flight retrieveFlight(int id) {
        Flight retFlight = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM Flight WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int flightNumber = resultSet.getInt("flightNumber");
                String flightName = resultSet.getString("flightName");
                String arrivalTime = resultSet.getString("arrivalTime");
                String arrivalDate = resultSet.getString("arrivalDate");
                String departureTime = resultSet.getString("departureTime");
                String departureDate = resultSet.getString("departureDate");
                String destination = resultSet.getString("destination");
                int airplaneId = resultSet.getInt("airplaneId");
                String departureCity = resultSet.getString("departureCity");
                String arrivalCity = resultSet.getString("arrivalCity");
                int classA = resultSet.getInt("classA");
                int classB = resultSet.getInt("classB");
                int classC = resultSet.getInt("classC");
                double classAPirce = resultSet.getDouble("classAPirce");
                double classBPirce = resultSet.getDouble("classBPirce");
                double classCPirce = resultSet.getDouble("classCPirce");
                System.out.println("time = " + arrivalTime + " : " + " date = " + arrivalDate);
                retFlight = new Flight(flightNumber, flightName, arrivalTime, arrivalDate, departureTime, departureDate, destination, airplaneId, arrivalCity, departureCity, classA, classB, classC, classAPirce, classBPirce, classCPirce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(connection, preparedStatement);
        }

        return retFlight;
    }

    @Override
    public Flight orderTicket(int id, String type) {
        Flight retFlight = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int ret = 0;

        Flight flight = retrieveFlight(id);

        int seatNumber = 0;
        switch (type) {
            case "classA":
                seatNumber = flight.getClassA();
                break;
            case "classB":
                seatNumber = flight.getClassB();
                break;
            case "classC":
                seatNumber = flight.getClassC();
                break;
            default:
                throw new IllegalArgumentException("Invalid class type for this flight");
        }

        if (seatNumber <= 0) {
            return null;
        }
        seatNumber--;


        try {
            flight.getFlightNumber();
            connection = DBUtil.getConnection();
            String query = "UPDATE TABLE Flight SET " + type + " = " + seatNumber + " WHERE flightNumber = ? ; ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flight.getFlightNumber());
            ret = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement);
        }
        if (ret != 0) {
            retFlight = flight;
        }

        return retFlight;
    }
}
