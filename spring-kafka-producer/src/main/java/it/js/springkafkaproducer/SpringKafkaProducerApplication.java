package it.js.springkafkaproducer;

import it.js.commons.dto.NewOrder;
import it.js.springkafkaproducer.service.KafkaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class SpringKafkaProducerApplication {

    static void main(String[] args) {
        SpringApplication.run(SpringKafkaProducerApplication.class, args);
    }


    @Bean
    CommandLineRunner sender(KafkaProducer producer) {

        return args -> {
            String message = "New order Patata";
            producer.send(message);
            final NewOrder newOrder = createNewOrder();

            producer.sendObject(newOrder);
        };
    }

    private NewOrder createNewOrder() {
        final NewOrder newOrder = new NewOrder();
        newOrder.setCustomer("Ordine");
        final ArrayList<Integer> orderIds = new ArrayList<>();
        orderIds.add((int) System.currentTimeMillis());
        orderIds.add(1);
        newOrder.setOrderIds(orderIds);
        return newOrder;
    }
}
