package hu.cscs.poc.jms_db.entrypoint.jms;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import hu.cscs.poc.jms_db.persistence.entity.Customer;
import hu.cscs.poc.jms_db.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class JMSListener {

    private final CustomerService customerService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = "DEV.QUEUE.1")
    // @Transactional
    public void process(final String message) {

        jmsTemplate.convertAndSend("DEV.QUEUE.2", UUID.randomUUID().toString());

        log.info(message);
        Customer customer = Customer.builder().name(message).build();
        customerService.save(customer);
    }
}
