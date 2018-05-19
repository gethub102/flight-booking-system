package com.offer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPoool {
    List<Connection> availableConnections = new ArrayList<>();

    public ConnectionPoool()
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

        if(availableConnections.size() < MAX_POOL_SIZE)
        {
            return false;
        }

        return true;
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
