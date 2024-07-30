package hu.cscs.poc.jms_db.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.cscs.poc.jms_db.persistence.entity.Customer;
import hu.cscs.poc.jms_db.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer save(Customer customer) {

        customer = customerRepository.save(customer);

        if (customer.getId() % 10 == 0) {
            throw new RuntimeException("something went wrong");
        }
        return customer;
    }
}
