package es.bikeid.tracker.service.spot.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Feed {

    private String id;
    private String name;
    private String description;
    private String status;
    private int usage;
    private int daysRange;
    private boolean detailedMessageShown;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(int daysRange) {
        this.daysRange = daysRange;
    }

    public boolean isDetailedMessageShown() {
        return detailedMessageShown;
    }

    public void setDetailedMessageShown(boolean detailedMessageShown) {
        this.detailedMessageShown = detailedMessageShown;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}