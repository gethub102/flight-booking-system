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
                retPassenger = new Passenger();
                retPassenger.setEmail(resultSet.getString("email"));
                retPassenger.getPerson().setFirstName(resultSet.getString("firstName"));
                retPassenger.getPerson().setLastName(resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        return retPassenger;
    }
}
