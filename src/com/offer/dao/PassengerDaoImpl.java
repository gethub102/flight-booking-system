package com.offer.dao;

import com.offer.db.DBUtil;
import com.offer.domain.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDaoImpl implements PassengerDao {

    @Override
    public Passenger login(Passenger passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Passenger retPassenger = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM Passenger WHERE email = ? AND password = ?; ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, passenger.getEmail());
            preparedStatement.setString(2, passenger.getPassword());
            resultSet = DBUtil.getResult(preparedStatement);
            if (resultSet.next()) {
                retPassenger = retrievePassengerFromDB(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        return retPassenger;
    }

    private Passenger retrievePassengerFromDB(ResultSet resultSet) {
        Passenger retPassenger = new Passenger();
        try {
            int passengerId = 0;
            passengerId = resultSet.getInt("passengerId");
            String email = resultSet.getString("email");
            String fname = resultSet.getString("firstName");
            String lname = resultSet.getString("lastName");
            String ssn = resultSet.getString("ssn");
            int age = resultSet.getInt("age");
            String street = resultSet.getString("street");
            String appartmentNumber = resultSet.getString("appartmentNumber");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String zip = resultSet.getString("zip");
            String telHome = resultSet.getString("telHome");
            String telOffice = resultSet.getString("telOffice");
            retPassenger.setEmail(email);
            retPassenger.setFirstName(fname);
            retPassenger.setLastName(lname);
            retPassenger.setId(passengerId);
            retPassenger.setSsn(ssn);
            retPassenger.setAge(age);
            retPassenger.setStreet(street);
            retPassenger.setApartmentNumber(appartmentNumber);
            retPassenger.setCity(city);
            retPassenger.setState(state);
            retPassenger.setZip(zip);
            retPassenger.setTelHome(telHome);
            retPassenger.setTelOffice(telOffice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retPassenger;
    }

    @Override
    public Passenger updateProfile(Passenger passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Passenger retPassenger = null;
        int queryResult = 0;
        try {
            connection = DBUtil.getConnection();
            int id = passenger.getId();
            String updateQuery = "UPDATE Passenger SET firstName = ?, lastName = ?, ssn = ?, age = ?, street = ?, appartmentNumber = ?, city = ?, state = ?, zip = ?, telHome = ?, telOffice = ? WHERE passengerId = ?; ";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, passenger.getFirstName());
            preparedStatement.setString(2, passenger.getLastName());
            preparedStatement.setString(3, passenger.getSsn());
            preparedStatement.setInt(4, passenger.getAge());
            preparedStatement.setString(5, passenger.getStreet());
            preparedStatement.setString(6, passenger.getApartmentNumber());
            preparedStatement.setString(7, passenger.getCity());
            preparedStatement.setString(8, passenger.getState());
            preparedStatement.setString(9, passenger.getZip());
            preparedStatement.setString(10, passenger.getTelHome());
            preparedStatement.setString(11, passenger.getTelOffice());
            preparedStatement.setInt(12, id);
            System.out.println(preparedStatement.toString());
            queryResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        if (queryResult != 0) {
            retPassenger = passenger;
        }
        return retPassenger;
    }
}
