package com.google.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    // 此注解，易忘。★
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        List<UserDetails> userList = new ArrayList<>();

        userList.add(User.withDefaultPasswordEncoder().username("fuck").password("1234").roles("USER").build());

        return new InMemoryUserDetailsManager(userList);
    }
}
