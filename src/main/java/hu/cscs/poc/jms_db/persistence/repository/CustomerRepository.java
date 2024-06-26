package hu.cscs.poc.jms_db.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import hu.cscs.poc.jms_db.persistence.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    long count();
}
