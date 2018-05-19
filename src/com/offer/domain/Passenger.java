package com.offer.domain;

public class Passenger {
    private Person person;
    private String ssn;
    private String street;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zip;
    private String telHome;
    private String telOffice;
    private String email;
    private String password;

    public Passenger() {
        this.person = new Person();
    }

    public Passenger(String email, String password) {
        this.email = email;
        this.password = password;
        this.person = new Person();
    }

    public Passenger(Person person, String ssn, String street, String apartmentNumber, String city, String state, String zip, String telHome, String telOffice, String email) {
        this.person = person;
        this.ssn = ssn;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telHome = telHome;
        this.telOffice = telOffice;
        this.email = email;
    }

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelOffice() {
        return telOffice;
    }

    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
