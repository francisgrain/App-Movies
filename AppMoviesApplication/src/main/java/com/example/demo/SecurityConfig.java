package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Per gestire CSRF, puoi abilitare/disabilitare in base alle tue esigenze
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/", "/getMovie", "/add", "/del").permitAll()  // Aggiorna con requestMatchers()
                .anyRequest().authenticated()
            )
            .formLogin().and()
            .httpBasic();

        return http.build();
    }
}
