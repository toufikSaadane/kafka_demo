package toufik.media.producer.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import toufik.media.producer.event.WikimediaChangesHandler;
import toufik.media.producer.util.KafkaConst;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikimediaKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate);
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(KafkaConst.WIKIMEDIA_RECENT_URL));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }

}
