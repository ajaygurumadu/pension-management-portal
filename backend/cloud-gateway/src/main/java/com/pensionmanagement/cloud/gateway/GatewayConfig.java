package com.pensionmanagement.cloud.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;



@Configuration
@CrossOrigin
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	@CrossOrigin(origins="http://localhost:4200")
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("authenticate", r -> r.path("/authenticate/**").filters(f -> f.filter(filter)).uri("lb://JWT-AUTH"))
				.route("pensioner", r -> r.path("/pensioner/**").filters(f -> f.filter(filter)).uri("lb://PENSIONER-DETAIL-MICROSERVICE"))
				.route("pension", r -> r.path("/pension/**").filters(f -> f.filter(filter)).uri("lb://PROCESS-PENSION-MICROSERVICE")).build();
	}

}
