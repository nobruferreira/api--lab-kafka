package com.lab;

import com.lab.avro.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    /*@PostMapping("send")
    public void send() {

        for (int i = 0; i < 100; i++) {

            log.info("Payload enviado: {}" +  "msg teste");

            Person person = Person.newBuilder()
                    .setName("Bruno")
                    .setCpf("XXX")
                    .setAge(i)
                    .build();

            kafkaTemplate.send("topic.test", person).addCallback(
                success -> log.info("Sucesso"),
                error -> log.info("Falha")
            );
        }
    }*/

    @PostMapping("send")
    public void send() {

        for (int i = 0; i < 100; i++) {

            log.info("Payload enviado: {}" +  "msg teste");

            kafkaTemplate.send("topic.test", "--- MSG: " + i + "---").addCallback(
                    success -> log.info("Sucesso"),
                    error -> log.info("Falha")
            );
        }
    }
}
