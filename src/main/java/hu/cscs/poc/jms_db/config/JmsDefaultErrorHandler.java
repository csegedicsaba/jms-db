package hu.cscs.poc.jms_db.config;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JmsDefaultErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        log.error("Error in JmsDefaultErrorHandler", t);
    }
}
