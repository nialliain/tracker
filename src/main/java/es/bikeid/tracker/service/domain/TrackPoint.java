package es.bikeid.tracker.service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrackPoint {

    private BigDecimal lat, lon;
    private LocalDateTime timeStamp;
    private String messageType;

    public TrackPoint(BigDecimal lat, BigDecimal lon, LocalDateTime timeStamp, String messageType) {
        this.lat = lat;
        this.lon = lon;
        this.timeStamp = timeStamp;
        this.messageType = messageType;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public boolean isMoreRecentThan(TrackPoint otherTrackPoint) {
        return otherTrackPoint != null && this.timeStamp.isAfter(otherTrackPoint.getTimeStamp());
    }

    @Override
    public String toString(){
        return "TrackPoint[" + getMessageType() + " at " + getLat() + "," + getLon() + " received " + getTimeStamp() + "]";
    }
}
