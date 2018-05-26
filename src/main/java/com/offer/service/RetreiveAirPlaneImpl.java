package main.java.com.offer.service;

import main.java.com.offer.dao.AirPlaneDao;
import main.java.com.offer.dao.AirPlaneDaoImpl;
import main.java.com.offer.domain.AirPlane;

import java.util.List;

public class RetreiveAirPlaneImpl implements RetreiveAirPlane {
    @Override
    public List<AirPlane> retreiveAirPlane() {
        AirPlaneDao airPlaneDao = new AirPlaneDaoImpl();
        return airPlaneDao.listAirPlane();
    }
}
