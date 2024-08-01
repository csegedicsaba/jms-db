package hu.cscs.poc.jms_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication(
        exclude = { JmxAutoConfiguration.class, JmxEndpointAutoConfiguration.class, WebFluxAutoConfiguration.class, SecurityAutoConfiguration.class },
        scanBasePackages = { "hu.cscs.poc.jms_db" })
//@EnableTransactionManagement
public class JmsDbApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JmsDbApplication.class, args);
    }

}
