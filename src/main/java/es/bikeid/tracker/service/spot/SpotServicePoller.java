package es.bikeid.tracker.service.spot;

import es.bikeid.tracker.service.web.NotificationService;
import es.bikeid.tracker.service.TrackService;
import es.bikeid.tracker.service.domain.TrackPoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@EnableScheduling
public class SpotServicePoller {

    private static Log LOGGER = LogFactory.getLog(NotificationService.class);
    private final String SPOT_URL = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/0kh77fpkuvgEaVFm0LklfeKXetFB6Iqgr/message.json";

    @Autowired
    TrackService trackService;

    private Queue<TrackPoint> tempPointQ= new ConcurrentLinkedQueue<>();

    public SpotServicePoller(){
        tempPointQ.add(new TrackPoint(new BigDecimal("55.95541"), new BigDecimal("-3.11176")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.87524"), new BigDecimal("-2.74408")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.85334"), new BigDecimal("-2.75122")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.82111"), new BigDecimal("-2.73019")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.78707"), new BigDecimal("-2.73447")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.72218"), new BigDecimal("-2.73413")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.70465"), new BigDecimal("-2.76453")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.66276"), new BigDecimal("-2.74273")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.6162"), new BigDecimal("-2.73715")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.60564"), new BigDecimal("-2.7521")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.5859"), new BigDecimal("-2.77596")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.56376"), new BigDecimal("-2.78677")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.65178"), new BigDecimal("-3.18613")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.66338"), new BigDecimal("-3.20728")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.68913"), new BigDecimal("-3.23186")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.70166"), new BigDecimal("-3.28284")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.76467"), new BigDecimal("-3.36569")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.81012"), new BigDecimal("-3.3172")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.82514"), new BigDecimal("-3.31763")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.90688"), new BigDecimal("-3.30364")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.95542"), new BigDecimal("-3.32218")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.98061"), new BigDecimal("-3.21472")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.95806"), new BigDecimal("-3.11813")));
        tempPointQ.add(new TrackPoint(new BigDecimal("55.95124"), new BigDecimal("-3.19138")));
    }

    @Scheduled(fixedDelay=1800000)
    public void mockPollSpotForNewUpdates(){
        LOGGER.info("MOCK for Spot interaction, adding some stored data.");
        if(!tempPointQ.isEmpty()){
            trackService.addTrackPoint(tempPointQ.remove());
        }
    }

//    @Scheduled(fixedDelay=1800000) // 30 minutes
//    public void pollSpotForNewUpdates(){
//        LOGGER.info("Polling SPOT.");
//        RestTemplate restTemplate = new RestTemplate();
//        SpotResponseMessage result = restTemplate.getForObject(SPOT_URL, SpotResponseMessage.class);
//        for (SpotResponseMessage.SpotResponse.FeedMessageResponse.SpotMessages.SpotMessage message : result.getResponse().getFeedMessageResponse().getSpotMessages().getMessages()){
//            System.out.println(message.getMessageType() + ": " + message.getLatitude() + ", " + message.getLongitude());
//        }
//    }

}
