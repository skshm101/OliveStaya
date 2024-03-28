package com.olivestays.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Configuration Class
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.config
* @project OliveStays
* @since 28-Mar-2024
 */
@Configuration
public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/olivestays/customers/register").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/admins/register").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/hotels/register").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/customers/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/admins/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/hotels/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/olivestays/rooms/add").hasRole("HOTEL")
        .requestMatchers(HttpMethod.PUT, "/olivestays/customers/update").hasRole("CUSTOMER")
        .requestMatchers(HttpMethod.GET, "/olivestays/customers/getToBeDeletedAccounts").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
