package es.bikeid.tracker.service;

import es.bikeid.tracker.service.domain.TrackPoint;
import es.bikeid.tracker.service.domain.TrackPointConsumer;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TrackService {

    private List<TrackPointConsumer> trackPointConsumers = new LinkedList<>();
    private List<TrackPoint> trackPoints = new LinkedList<>();
    TrackPoint latest = null;

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
        latest = trackPoint;
        for(TrackPointConsumer c : trackPointConsumers){
            c.newTrackPoint(trackPoint);
        }
    }

    public TrackPoint getLatestPoint() {
        return latest;
    }

    public List<TrackPoint> getAllPoints() {
        return trackPoints;
    }

    public void registerForUpdate(TrackPointConsumer trackPointConsumer) {
        trackPointConsumers.add(trackPointConsumer);
    }
}
