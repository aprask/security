package com.example.security.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().
                username("john").
                password("{noop}test123").
                roles("ROMAN").
                build();
        UserDetails augustus = User.builder().
                username("augustus").
                password("{noop}bob500").
                roles("ROMAN", "EMPEROR").
                build();
        UserDetails jupiter = User.builder().
                username("jupiter").
                password("{noop}fish990").
                roles("ROMAN", "EMPEROR", "GOD").
                build();
        return new InMemoryUserDetailsManager(john, augustus, jupiter);
    }
}














