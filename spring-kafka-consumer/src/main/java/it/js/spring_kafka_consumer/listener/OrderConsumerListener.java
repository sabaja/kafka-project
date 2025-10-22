package it.js.spring_kafka_consumer.listener;

import it.js.commons.dto.NewOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class OrderConsumerListener {

    @KafkaListener(topics = "new-string-orders", groupId = "exercise-string-group-id", containerFactory = "stringContainerFactory")
    public void listen(String order) {

        log.info("String order received {}", order);
    }

    @KafkaListener(topics = "new-object-orders", groupId = "exercise-object-group-id", containerFactory = "objectContainerFactory")
    public void listenObject(NewOrder newOrder){
        log.info("Object order received {}", newOrder);
    }
}
