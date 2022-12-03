package com.IngeSoft.BicisBogota;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	/*
	@Bean
	public UserDetailsService userDetailsService() {

		UserDetailsService userDetailsService;
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("julian")
				.password("bicisbogota")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	*/

	@Bean
	public InMemoryUserDetailsManager userDetailsService () {
		InMemoryUserDetailsManager usuarios = new InMemoryUserDetailsManager ();

		usuarios.createUser( User 
			.withDefaultPasswordEncoder()
			.username("mapu")
			.password("bicisbogota")
			.roles("USER")
			.build()
		);

		usuarios.createUser( User 
			.withDefaultPasswordEncoder()
			.username("fabian")
			.password("bicisbogota")
			.roles("USER")
			.build()
		);

		usuarios.createUser( User 
			.withDefaultPasswordEncoder()
			.username("julian")
			.password("bicisbogota")
			.roles("ADMIN")
			.build()
		);
		
		return usuarios;

	}
}