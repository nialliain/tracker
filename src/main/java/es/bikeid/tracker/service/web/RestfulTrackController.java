package es.bikeid.tracker.service.web;

import es.bikeid.tracker.service.TrackService;
import es.bikeid.tracker.service.domain.TrackPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestfulTrackController {

    @Autowired
    TrackService trackService;

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<TrackPoint> history() {
        return trackService.getAllPoints();
    }

    @RequestMapping(path = "/latest", method = RequestMethod.GET)
    public TrackPoint latest() {
        return trackService.getLatestPoint();
    }

}
