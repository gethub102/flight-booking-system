package main.java.com.offer.dao;

import main.java.com.offer.db.DBUtil;
import main.java.com.offer.domain.AirPlane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneDaoImpl implements AirPlaneDao {
    @Override
    public AirPlane addAirPlane(AirPlane airPlane) {
        AirPlane retAiPlane = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int queryResult = 0;

        try {
            connection = DBUtil.getConnection();
            String addAirPlane = "INSERT INTO Airplane (producer, type) VALUES (?, ?); ";
            preparedStatement = connection.prepareStatement(addAirPlane);
            preparedStatement.setString(1, airPlane.getProducer());
            preparedStatement.setString(2, airPlane.getType());
            System.out.println(preparedStatement.toString());
            queryResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (queryResult != 0) {
            retAiPlane = airPlane;
        }

        return retAiPlane;
    }

    @Override
    public List<AirPlane> listAirPlane() {
        List<AirPlane> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM Airplane; ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String producer = resultSet.getString("producer");
                String type = resultSet.getString("type");
                int airplaneId = resultSet.getInt("airplaneId");
                AirPlane airPlane = new AirPlane(producer, type);
                airPlane.setAirplanId(airplaneId);
                list.add(airPlane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
