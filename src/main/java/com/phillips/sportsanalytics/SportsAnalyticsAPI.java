package com.phillips.sportsanalytics;

import com.azure.cosmos.implementation.guava25.collect.ImmutableList;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.phillips.sportsanalytics.util.HTTPConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableCaching
@EnableCosmosRepositories
@EnableScheduling
public class SportsAnalyticsAPI {
	private static final Logger logger = LogManager.getLogger(SportsAnalyticsAPI.class);

	public static void main(String[] args) {
		HTTPConnection.init();
		final ConfigurableApplicationContext context = SpringApplication.run(SportsAnalyticsAPI.class, args);
		final AtomicInteger counter = new AtomicInteger(0);
		logger.info("**************** START: Total Bean Objects: {} ******************", context.getBeanDefinitionCount());

		Arrays.asList(context.getBeanDefinitionNames())
				.forEach(beanName -> logger.info("{}) Bean Name: {} ", counter.incrementAndGet(), beanName));

		logger.info("**************** END: Total Bean: {} ******************", context.getBeanDefinitionCount());

	}

	@Configuration
	public class WebConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
		}
	}

	@Configuration
	public class SecurityConfig {

		@Bean
		public CorsConfigurationSource corsConfigurationSource() {
			final CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(ImmutableList.of("*"));
			configuration.setAllowedMethods(ImmutableList.of("HEAD",
					"GET", "POST", "PUT", "DELETE", "PATCH"));
			// setAllowCredentials(true) is important, otherwise:
			// The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
			configuration.setAllowCredentials(true);
			// setAllowedHeaders is important! Without it, OPTIONS preflight request
			// will fail with 403 Invalid CORS request
			configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}
}
