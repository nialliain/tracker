package es.bikeid.tracker.service.spot.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response {

    private FeedMessageResponse feedMessageResponse;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public FeedMessageResponse getFeedMessageResponse() {
        return feedMessageResponse;
    }

    public void setFeedMessageResponse(FeedMessageResponse feedMessageResponse) {
        this.feedMessageResponse = feedMessageResponse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}