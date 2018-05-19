package com.offer.db;

public class DBConfigure {
    private static final String _DRIVER = "com.mysql.jdbc.Driver";
    private static final String _URL = "jdbc:mysql://localhost:3307/FlightBook";
    private static final String _USERNAME = "root";
    private static final String _PASSWORD = "root";
    private static final int _DB_MAX_CONNECTIONS = 10;

    public static String getDRIVER() {
        return _DRIVER;
    }

    public static String getURL() {
        return _URL;
    }

    public static String getUSERNAME() {
        return _USERNAME;
    }

    public static String getPASSWORD() {
        return _PASSWORD;
    }

    public static int getDbMaxConnections() {
        return _DB_MAX_CONNECTIONS;
    }
}
