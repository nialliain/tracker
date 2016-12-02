package es.bikeid.tracker.service.spot.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Messages {

    private List<Message> message = new ArrayList<>();
    private Map<String, Object> additionalProperties = new HashMap<>();

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}