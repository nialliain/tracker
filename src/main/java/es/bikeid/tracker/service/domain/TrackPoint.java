package es.bikeid.tracker.service.domain;

import java.math.BigDecimal;

public class TrackPoint {

    private BigDecimal lat, lon;

    public TrackPoint(BigDecimal lat, BigDecimal lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

}
