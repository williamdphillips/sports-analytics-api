package com.phillips.sportsanalytics;

import com.google.common.collect.ImmutableList;
import com.phillips.sportsanalytics.util.HTTPConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SportsAnalyticsAPI {

	public static void main(String[] args) {
		HTTPConnection.init();
		SpringApplication.run(SportsAnalyticsAPI.class, args);
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

		@CacheEvict(allEntries = true, value = {"plays", "games", "static"})
		@Scheduled(fixedRate = 30000)
		public void clearCache() {
			System.out.println("Cache cleared");
		}
	}
}
