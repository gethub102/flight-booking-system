package main.java.com.offer.service;

import main.java.com.offer.dao.AirPlaneDao;
import main.java.com.offer.dao.AirPlaneDaoImpl;
import main.java.com.offer.domain.AirPlane;

public class AddAirPlaneImpl implements AddAirPlane {
    @Override
    public AirPlane addAirPlane(AirPlane airPlane) {
        AirPlaneDao airPlaneDao = new AirPlaneDaoImpl();
        return airPlaneDao.addAirPlane(airPlane);
    }
}
