package hu.cscs.poc.jms_db.entrypoint.jms;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import hu.cscs.poc.jms_db.persistence.entity.Customer;
import hu.cscs.poc.jms_db.persistence.repository.CustomerRepository;
import hu.cscs.poc.jms_db.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class JMSListener {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = "DEV.QUEUE.1")
    public void process(final String message) {

        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setSessionTransacted(true);

        log.info(message);
        Customer customer = Customer.builder().name(message).build();
        customer = customerService.save(customer);

        jmsTemplate.convertAndSend("DEV.QUEUE.2", UUID.randomUUID().toString());

    }
}
