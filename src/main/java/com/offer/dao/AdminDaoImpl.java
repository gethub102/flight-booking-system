package main.java.com.offer.dao;

import main.java.com.offer.db.DBUtil;
import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin login(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin retAdmin = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM Admin WHERE email = ? AND password = ?; ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());
            resultSet = DBUtil.getResult(preparedStatement);
            if (resultSet.next()) {
                retAdmin = retrieveAdminFromDB(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        return retAdmin;
    }

    @Override
    public Admin updateProfile(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin retAmin = null;
        int queryResult = 0;
        try {
            connection = DBUtil.getConnection();
            int id = admin.getId();
            String updateQuery = "UPDATE Admin SET firstName = ?, lastName = ?, ssn = ?, age = ?, street = ?, appartmentNumber = ?, city = ?, state = ?, zip = ?, telHome = ?, telOffice = ? WHERE passengerId = ?; ";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, admin.getFirstName());
            preparedStatement.setString(2, admin.getLastName());
            preparedStatement.setString(3, admin.getSsn());
            preparedStatement.setInt(4, admin.getAge());
            preparedStatement.setString(5, admin.getStreet());
            preparedStatement.setString(6, admin.getApartmentNumber());
            preparedStatement.setString(7, admin.getCity());
            preparedStatement.setString(8, admin.getState());
            preparedStatement.setString(9, admin.getZip());
            preparedStatement.setString(10, admin.getTelHome());
            preparedStatement.setString(11, admin.getTelOffice());
            preparedStatement.setInt(12, id);
            System.out.println(preparedStatement.toString()); // => this is a show of sql statement
            queryResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeDbResources(connection, preparedStatement, resultSet);
        }
        if (queryResult != 0) {
            retAmin = admin;
        }
        return retAmin;
    }

    private Admin retrieveAdminFromDB(ResultSet resultSet) {
        Admin retPassenger = new Admin();
        try {
            int adminId = 0;
            adminId = resultSet.getInt("adminId");
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
            retPassenger.setId(adminId);
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
}
