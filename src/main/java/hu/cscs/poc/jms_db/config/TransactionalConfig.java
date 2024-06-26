package hu.cscs.poc.jms_db.config;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.jms.ConnectionFactory;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableJms
public class TransactionalConfig {

    // @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer, JmsDefaultErrorHandler errorHandler,
            PlatformTransactionManager platformTransactionManager) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(errorHandler);
        factory.setSessionTransacted(true);
        factory.setTransactionManager(platformTransactionManager);
        factory.setExceptionListener(e -> log.error("Hiba a DefaultJmsListenerContainer-ben", e));
        return factory;
    }
}
