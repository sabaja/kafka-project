package it.js.springkafkaproducer.service;

import it.js.commons.dto.NewOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, NewOrder> newOrderkafkaTemplate;

    public KafkaProducer(@Qualifier("stringKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate,
                         @Qualifier("newOrderKafkaTemplate") KafkaTemplate<String, NewOrder> newOrderkafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.newOrderkafkaTemplate = newOrderkafkaTemplate;
    }

    public void send(String order) {
        String topic = "new-string-orders";
        kafkaTemplate.send(topic, order);

        log.info("sent: {}", order);
    }

    public void sendObject(NewOrder newOrder) {
        String topic = "new-object-orders";
        newOrderkafkaTemplate.send(topic, newOrder);

        log.info("sent object: {}", newOrder);

    }
}
