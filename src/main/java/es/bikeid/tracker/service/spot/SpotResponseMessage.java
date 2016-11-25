package es.bikeid.tracker.service.spot;

import java.math.BigDecimal;
import java.util.List;

public class SpotResponseMessage {

    private SpotResponse response;

    public SpotResponse getResponse() {
        return response;
    }

    public void setResponse(SpotResponse response) {
        this.response = response;
    }

    public class SpotResponse {

        private FeedMessageResponse feedMessageResponse;

        public FeedMessageResponse getFeedMessageResponse() {
            return feedMessageResponse;
        }

        public void setFeedMessageResponse(FeedMessageResponse feedMessageResponse) {
            this.feedMessageResponse = feedMessageResponse;
        }

        public class FeedMessageResponse {

            private SpotMessages spotMessages;

            public SpotMessages getSpotMessages() {
                return spotMessages;
            }

            public void setSpotMessages(SpotMessages spotMessages) {
                this.spotMessages = spotMessages;
            }

            public class SpotMessages {

                private List<SpotMessage> messages;

                public List<SpotMessage> getMessages() {
                    return messages;
                }

                public void setMessages(List<SpotMessage> messages) {
                    this.messages = messages;
                }


                public class SpotMessage {

                    private BigDecimal latitude;
                    private BigDecimal longitude;
                    private String messageType;
                    private String dateTime;

                    public String getDateTime() {
                        return dateTime;
                    }

                    public void setDateTime(String dateTime) {
                        this.dateTime = dateTime;
                    }

                    public String getMessageType() {
                        return messageType;
                    }

                    public void setMessageType(String messageType) {
                        this.messageType = messageType;
                    }

                    public BigDecimal getLongitude() {
                        return longitude;
                    }

                    public void setLongitude(BigDecimal longitude) {
                        this.longitude = longitude;
                    }

                    public BigDecimal getLatitude() {
                        return latitude;
                    }

                    public void setLatitude(BigDecimal latitude) {
                        this.latitude = latitude;
                    }

                }

            }
        }

    }

}
