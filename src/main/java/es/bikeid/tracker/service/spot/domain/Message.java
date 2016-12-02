package es.bikeid.tracker.service.spot.domain;

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
    private float latitude;
    private float longitude;
    private String modelId;
    private String showCustomMsg;
    private String dateTime;
    private String batteryState;
    private int hidden;
    private String messageContent;
    private int altitude;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The clientUnixTime
     */
    public String getClientUnixTime() {
        return clientUnixTime;
    }

    /**
     *
     * @param clientUnixTime
     * The @clientUnixTime
     */
    public void setClientUnixTime(String clientUnixTime) {
        this.clientUnixTime = clientUnixTime;
    }

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The messengerId
     */
    public String getMessengerId() {
        return messengerId;
    }

    /**
     *
     * @param messengerId
     * The messengerId
     */
    public void setMessengerId(String messengerId) {
        this.messengerId = messengerId;
    }

    /**
     *
     * @return
     * The messengerName
     */
    public String getMessengerName() {
        return messengerName;
    }

    /**
     *
     * @param messengerName
     * The messengerName
     */
    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    /**
     *
     * @return
     * The unixTime
     */
    public int getUnixTime() {
        return unixTime;
    }

    /**
     *
     * @param unixTime
     * The unixTime
     */
    public void setUnixTime(int unixTime) {
        this.unixTime = unixTime;
    }

    /**
     *
     * @return
     * The messageType
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     *
     * @param messageType
     * The messageType
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     *
     * @return
     * The latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     *
     * @param modelId
     * The modelId
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     *
     * @return
     * The showCustomMsg
     */
    public String getShowCustomMsg() {
        return showCustomMsg;
    }

    /**
     *
     * @param showCustomMsg
     * The showCustomMsg
     */
    public void setShowCustomMsg(String showCustomMsg) {
        this.showCustomMsg = showCustomMsg;
    }

    /**
     *
     * @return
     * The dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     *
     * @param dateTime
     * The dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     *
     * @return
     * The batteryState
     */
    public String getBatteryState() {
        return batteryState;
    }

    /**
     *
     * @param batteryState
     * The batteryState
     */
    public void setBatteryState(String batteryState) {
        this.batteryState = batteryState;
    }

    /**
     *
     * @return
     * The hidden
     */
    public int getHidden() {
        return hidden;
    }

    /**
     *
     * @param hidden
     * The hidden
     */
    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    /**
     *
     * @return
     * The messageContent
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     *
     * @param messageContent
     * The messageContent
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     *
     * @return
     * The altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     *
     * @param altitude
     * The altitude
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
