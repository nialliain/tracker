package es.bikeid.tracker.service.spot.domain;

import es.bikeid.tracker.service.domain.TrackPoint;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Message {

    private String clientUnixTime;
    private int id;
    private String messengerId;
    private String messengerName;
    private int unixTime;
    private String messageType;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String modelId;
    private String showCustomMsg;
    private String dateTime;
    private String batteryState;
    private int hidden;
    private String messageContent;
    private int altitude;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getClientUnixTime() {
        return clientUnixTime;
    }

    public void setClientUnixTime(String clientUnixTime) {
        this.clientUnixTime = clientUnixTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessengerId() {
        return messengerId;
    }

    public void setMessengerId(String messengerId) {
        this.messengerId = messengerId;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    public int getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(int unixTime) {
        this.unixTime = unixTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getShowCustomMsg() {
        return showCustomMsg;
    }

    public void setShowCustomMsg(String showCustomMsg) {
        this.showCustomMsg = showCustomMsg;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBatteryState() {
        return batteryState;
    }

    public void setBatteryState(String batteryState) {
        this.batteryState = batteryState;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public TrackPoint getTrackPoint() {
        return new TrackPoint(getLatitude(), getLongitude(), LocalDateTime.ofEpochSecond(getUnixTime(),0, ZoneOffset.UTC), getMessageType());
    }
}
