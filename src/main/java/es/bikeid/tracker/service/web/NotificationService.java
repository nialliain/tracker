package es.bikeid.tracker.service.web;

import es.bikeid.tracker.service.domain.TrackPointConsumer;
import es.bikeid.tracker.service.TrackService;
import es.bikeid.tracker.service.domain.TrackPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NotificationService implements TrackPointConsumer {

    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

    @Autowired
    private TrackService trackService;

    @PostConstruct
    void registerWithTrackService(){
        trackService.registerForUpdate(this);
    }

    @Override
    public void newTrackPoint(TrackPoint trackPoint) {
        this.messagingTemplate.convertAndSend("/topic/position", trackPoint);

    }
}
