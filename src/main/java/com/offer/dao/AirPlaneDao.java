package main.java.com.offer.dao;

import main.java.com.offer.domain.AirPlane;

import java.util.List;

public interface AirPlaneDao {
    AirPlane addAirPlane(AirPlane airPlane);
    List<AirPlane> listAirPlane();
}
