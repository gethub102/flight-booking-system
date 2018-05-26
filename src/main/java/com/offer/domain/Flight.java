package main.java.com.offer.domain;


import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {

    private int flightNumber;
    private String flightName;
//    private LocalTime arrivalTime;
//    private LocalDate arrivalDate;
//    private LocalTime departureTime;
//    private LocalDate departureDate;
    private String arrivalTime;
    private String arrivalDate;
    private String departureTime;
    private String departureDate;
    private String destination;
    private int airplaneId;
    private String departureCity;
    private String arrivalCity;
    private int classA;
    private int classB;
    private int classC;
    private double classAPirce;
    private double classBPirce;
    private double classCPirce;

    public Flight() {
    }

    public Flight(String flightName, String departureTime) {
        this.flightName = flightName;
        this.departureTime = departureTime;
    }

    public Flight(String flightName, String arrivalTime, String arrivalDate, String departureTime, String departureDate, String destination, int airplaneId, String departureCity, String arrivalCity) {
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.destination = destination;
        this.airplaneId = airplaneId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public Flight(String flightName, String arrivalTime, String arrivalDate, String departureTime, String departureDate, String destination, int airplaneId, String departureCity, String arrivalCity, int classA, int classB, int classC) {
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.destination = destination;
        this.airplaneId = airplaneId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.classA = classA;
        this.classB = classB;
        this.classC = classC;
    }

    public Flight(int flightNumber, String flightName, String arrivalTime, String arrivalDate, String departureTime, String departureDate, String destination, int airplaneId, String departureCity, String arrivalCity, int classA, int classB, int classC) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.destination = destination;
        this.airplaneId = airplaneId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.classA = classA;
        this.classB = classB;
        this.classC = classC;
    }

    public Flight(int flightNumber, String flightName, String arrivalTime, String arrivalDate, String departureTime, String departureDate, String destination, int airplaneId, String departureCity, String arrivalCity, int classA, int classB, int classC, double classAPirce, double classBPirce, double classCPirce) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.destination = destination;
        this.airplaneId = airplaneId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.classA = classA;
        this.classB = classB;
        this.classC = classC;
        this.classAPirce = classAPirce;
        this.classBPirce = classBPirce;
        this.classCPirce = classCPirce;
    }

    public double getClassAPirce() {
        return classAPirce;
    }

    public void setClassAPirce(double classAPirce) {
        this.classAPirce = classAPirce;
    }

    public double getClassBPirce() {
        return classBPirce;
    }

    public void setClassBPirce(double classBPirce) {
        this.classBPirce = classBPirce;
    }

    public double getClassCPirce() {
        return classCPirce;
    }

    public void setClassCPirce(double classCPirce) {
        this.classCPirce = classCPirce;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getClassA() {
        return classA;
    }

    public void setClassA(int classA) {
        this.classA = classA;
    }

    public int getClassB() {
        return classB;
    }

    public void setClassB(int classB) {
        this.classB = classB;
    }

    public int getClassC() {
        return classC;
    }

    public void setClassC(int classC) {
        this.classC = classC;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}
