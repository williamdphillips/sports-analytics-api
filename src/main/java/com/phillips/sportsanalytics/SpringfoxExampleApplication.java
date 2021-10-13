package com.phillips.sportsanalytics;

import com.phillips.sportsanalytics.services.NFLService;
import com.phillips.sportsanalytics.util.HTTPConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringfoxExampleApplication {

	public static void main(String[] args) {
		HTTPConnection.init();
		SpringApplication.run(SpringfoxExampleApplication.class, args);
	}

}
