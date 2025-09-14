package com.unsubble.lesson6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager getJdbcAuthUsers(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.setAuthoritiesByUsernameQuery("select name, role from custom_authorities where name=?");

        return manager;
    }

    /*
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$ com.unsubble.lesson6._02.Lesson6Sec2Application için $$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    @Bean
    public UserDetailsManager getJdbcAuthUsers(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
*/

    /*
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$ com.unsubble.lesson6._01.Lesson6Sec1Application için $$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


    @Bean
    public UserDetailsManager getAuthUsers() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password("{noop}user1234") // {noop} herhangi bir şifreleme kullanmamak için
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}user1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails user3 = User.builder()
                .username("user3")
                .password("{noop}user1234")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/employees/**").hasRole("MANAGER"));
        httpSecurity.httpBasic(Customizer.withDefaults());

        // csrf korumasını devre dışı bırakmak için
        // httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}
