package toufik.media.producer.event;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import toufik.media.producer.util.KafkaConst;

@Slf4j
@Service
public class WikimediaChangesHandler implements EventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info("================================================================ {}", messageEvent.getData());
        kafkaTemplate.send(KafkaConst.WIKIMEDIA_RECENT_TOPIC, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
