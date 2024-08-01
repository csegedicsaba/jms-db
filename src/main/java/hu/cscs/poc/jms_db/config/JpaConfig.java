package hu.cscs.poc.jms_db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import hu.cscs.poc.jms_db.JmsDbApplication;

@EnableJpaRepositories(basePackages = { "hu.cscs.poc.jms_db.persistence.repository" })
@EntityScan(basePackageClasses = { JmsDbApplication.class })
@Configuration
public class JpaConfig {
}
