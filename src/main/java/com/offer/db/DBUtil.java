package main.java.com.offer.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    static {
        try {
            Class.forName(DBConfigure.getDRIVER());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static PreparedStatement getPreparedStatement(Connection con, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static ResultSet getResult(PreparedStatement preparedStatement) {
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static int executeUpdate(PreparedStatement ps) {
        int i = -1;
        try {
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void closeDbResources(Connection con) {
        try {
            if (con != null)
                CONNECTION_POOL.returnConnectionToPool(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDbResources(Connection con, PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();

            if (con != null)
                CONNECTION_POOL.returnConnectionToPool(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDbResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();

            if (preparedStatement != null)
                preparedStatement.close();

            if (connection != null)
                CONNECTION_POOL.returnConnectionToPool(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return CONNECTION_POOL.getConnectionFromPool();
    }
}
