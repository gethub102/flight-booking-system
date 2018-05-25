package main.java.com.offer.domain;

public class AirPlane {
    private int airplanId;
    private String producer;
    private String type;

    public AirPlane() {
    }

    public AirPlane(String producer, String type) {

        this.producer = producer;
        this.type = type;
    }

    public int getAirplanId() {
        return airplanId;
    }

    public void setAirplanId(int airplanId) {
        this.airplanId = airplanId;
    }

    public String getProducer() {

        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
