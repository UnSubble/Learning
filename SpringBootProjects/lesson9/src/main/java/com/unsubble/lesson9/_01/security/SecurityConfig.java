package com.unsubble.lesson9._01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(configurer ->
                configurer.anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/myLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll());
        return security.build();
    }
}
