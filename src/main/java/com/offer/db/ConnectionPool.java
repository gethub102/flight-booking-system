package main.java.com.offer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> availableConnections = new ArrayList<>();

    public static final ConnectionPool CONNECTION_POOL = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return CONNECTION_POOL;
    }

    private ConnectionPool()
    {
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        while(!checkIfConnectionPoolIsFull())
        {
            availableConnections.add(createNewConnectionForPool());
        }
    }

    private synchronized boolean checkIfConnectionPoolIsFull()
    {
        final int MAX_POOL_SIZE = DBConfigure.getDbMaxConnections();

        return availableConnections.size() >= MAX_POOL_SIZE;
    }

    //Creating a connection
    private Connection createNewConnectionForPool()
    {
        try {
            Class.forName(DBConfigure.getDRIVER());
            Connection connection = DriverManager.getConnection(
                    DBConfigure.getURL(), DBConfigure.getUSERNAME(), DBConfigure.getPASSWORD());
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public synchronized Connection getConnectionFromPool()
    {
        Connection connection = null;
        if(availableConnections.size() > 0)
        {
            connection =  availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection)
    {
        availableConnections.add(connection);
    }
}
