package es.bikeid.tracker.service.spot;

import es.bikeid.tracker.service.spot.domain.Message;
import es.bikeid.tracker.service.spot.domain.SpotMessageFeed;
import es.bikeid.tracker.service.web.NotificationService;
import es.bikeid.tracker.service.TrackService;
import es.bikeid.tracker.service.domain.TrackPoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
@EnableScheduling
public class SpotServicePoller {

    private static final Log LOGGER = LogFactory.getLog(NotificationService.class);

    @SuppressWarnings("CanBeFinal")
    @Autowired
    TrackService trackService;

    @PostConstruct
    public void loadPreviousTrackPoints(){
        // TODO quick fix until I add persistance
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.95541"), new BigDecimal("-3.11176"), LocalDateTime.of(2016,11,21,1,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.87524"), new BigDecimal("-2.74408"), LocalDateTime.of(2016,11,21,2,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.85334"), new BigDecimal("-2.75122"), LocalDateTime.of(2016,11,21,3,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.82111"), new BigDecimal("-2.73019"), LocalDateTime.of(2016,11,21,4,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.78707"), new BigDecimal("-2.73447"), LocalDateTime.of(2016,11,21,5,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.72218"), new BigDecimal("-2.73413"), LocalDateTime.of(2016,11,21,6,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.70465"), new BigDecimal("-2.76453"), LocalDateTime.of(2016,11,21,7,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.66276"), new BigDecimal("-2.74273"), LocalDateTime.of(2016,11,21,8,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.6162"), new BigDecimal("-2.73715"), LocalDateTime.of(2016,11,21,9,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.60564"), new BigDecimal("-2.7521"), LocalDateTime.of(2016,11,21,10,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.5859"), new BigDecimal("-2.77596"), LocalDateTime.of(2016,11,21,11,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.56376"), new BigDecimal("-2.78677"), LocalDateTime.of(2016,11,21,12,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.65178"), new BigDecimal("-3.18613"), LocalDateTime.of(2016,11,21,13,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.66338"), new BigDecimal("-3.20728"), LocalDateTime.of(2016,11,22,1,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.68913"), new BigDecimal("-3.23186"), LocalDateTime.of(2016,11,22,2,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.70166"), new BigDecimal("-3.28284"), LocalDateTime.of(2016,11,22,3,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.76467"), new BigDecimal("-3.36569"), LocalDateTime.of(2016,11,22,4,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.81012"), new BigDecimal("-3.3172"), LocalDateTime.of(2016,11,22,5,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.82514"), new BigDecimal("-3.31763"), LocalDateTime.of(2016,11,22,6,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.90688"), new BigDecimal("-3.30364"), LocalDateTime.of(2016,11,22,7,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.95542"), new BigDecimal("-3.32218"), LocalDateTime.of(2016,11,22,8,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.98061"), new BigDecimal("-3.21472"), LocalDateTime.of(2016,11,22,9,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.95806"), new BigDecimal("-3.11813"), LocalDateTime.of(2016,11,22,10,0), "UNLIMITED TRACK"));
        trackService.addTrackPoint(new TrackPoint(new BigDecimal("55.95124"), new BigDecimal("-3.19138"), LocalDateTime.of(2016,11,22,11,0), "UNLIMITED TRACK"));
    }

    @Scheduled(fixedDelay=1800000) // 30 minutes
    public void pollSpotForNewUpdates(){
        LOGGER.info("Polling SPOT for new TrackPoints");
        TrackPoint latestPoint = trackService.getLatestPoint();
        RestTemplate restTemplate = new RestTemplate();
        String SPOT_URL = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/0kh77fpkuvgEaVFm0LklfeKXetFB6Iqgr/message.json";
        SpotMessageFeed result = restTemplate.getForObject(SPOT_URL, SpotMessageFeed.class);
        Collections.reverse(result.getResponse().getFeedMessageResponse().getMessages().getMessage());
        for (Message message : result.getResponse().getFeedMessageResponse().getMessages().getMessage()){
            TrackPoint receivedTrackPoint = message.getTrackPoint();
            if(receivedTrackPoint.isMoreRecentThan(latestPoint)){
                LOGGER.info("Addding new trackpoint; " + receivedTrackPoint);
                trackService.addTrackPoint(receivedTrackPoint);
                latestPoint = trackService.getLatestPoint();
            }
        }
    }

}
