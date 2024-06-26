package hu.cscs.poc.jms_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JmsDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsDbApplication.class, args);
    }

}
