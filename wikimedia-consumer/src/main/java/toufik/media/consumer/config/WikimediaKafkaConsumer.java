package toufik.media.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikimediaKafkaConsumer {
    String WIKIMEDIA_RECENT_TOPIC = "wikimedia_recent";


    @KafkaListener(topics = "wikimedia_recent", groupId = "myGroup")
    public void consume(String message) {
        log.info("========= message {}", message);
    }
}
