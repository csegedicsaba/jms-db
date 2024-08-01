package hu.cscs.poc.jms_db.entrypoint.rest;

import java.util.UUID;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cscs.poc.jms_db.persistence.entity.Customer;
import hu.cscs.poc.jms_db.persistence.repository.CustomerRepository;
import hu.cscs.poc.jms_db.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    private final CustomerRepository customerRepository;
    private final JmsTemplate jmsTemplate;
    private final CustomerService customerService;

    private

    @GetMapping("save") String save() {

        for (int i = 0; i < 100; i++) {
            Customer customer = Customer.builder().name(UUID.randomUUID().toString()).build();
            try {
                customerService.save(customer);
            } catch (Exception e) {
                log.error("error", e);
            }
        }

        return "Saved";
    }

    @GetMapping("send")
    String send() {
        for (int i = 0; i < 10; i++) {
            try {
                jmsTemplate.convertAndSend("DEV.QUEUE.1", UUID.randomUUID().toString());
            } catch (JmsException ex) {
                log.error("Error in sending: ", ex);
            }
        }
        return "Sent";
    }

    @GetMapping("count")
    String count() {
        return "count - " + customerRepository.count();
    }

}
