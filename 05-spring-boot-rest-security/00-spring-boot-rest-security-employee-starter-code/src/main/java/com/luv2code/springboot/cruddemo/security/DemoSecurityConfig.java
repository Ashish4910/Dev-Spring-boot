package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);
		jdbcUserDetailsManager.setUsersByUsernameQuery("Select user_id,pw,active from members where user_id=?");

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("Select user_id,role from roles where user_id=?");

		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(Configurer -> Configurer

				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

		);
		// http basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable the CSRF (Cross site request forgery)
		http.csrf(csrf -> csrf.disable());

		return http.build();

	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailmanager() {
	 * 
	 * UserDetails john = User.builder()
	 * 
	 * .username("John") .password("{noop}test123") .roles("EMPLOYEE").build();
	 * 
	 * UserDetails mary = User.builder() .username("Mary")
	 * .password("{noop}test123") .roles("EMPLOYEE", "MANAGER") .build();
	 * 
	 * UserDetails susan = User.builder()
	 * 
	 * .username("Susan") .password("{noop}test123") .roles("EMPLOYEE", "MANAGER",
	 * "ADMIN") .build(); return new InMemoryUserDetailsManager(john, mary, susan);
	 * 
	 * }
	 * 
	 */

}
