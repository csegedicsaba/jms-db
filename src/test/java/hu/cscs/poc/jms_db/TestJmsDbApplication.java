package hu.cscs.poc.jms_db;

import org.springframework.boot.SpringApplication;

public class TestJmsDbApplication {

	public static void main(String[] args) {
		SpringApplication.from(JmsDbApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
