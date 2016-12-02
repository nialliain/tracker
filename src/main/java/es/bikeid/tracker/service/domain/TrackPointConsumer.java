package es.bikeid.tracker.service.domain;

@FunctionalInterface
public interface TrackPointConsumer {

    void newTrackPoint(TrackPoint trackPoint);

}
