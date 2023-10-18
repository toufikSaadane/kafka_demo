package toufik.media.producer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import toufik.media.producer.kafka.WikimediaKafkaProducer;

@SpringBootApplication
@Slf4j
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private WikimediaKafkaProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage();
        log.info("================================================================ ");
    }
}
