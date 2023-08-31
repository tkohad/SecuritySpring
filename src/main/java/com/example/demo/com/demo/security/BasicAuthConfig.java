package com.example.demo.com.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       // BASIC AUTHENTICATION
        //http.httpBasic();
        //Form base authentication
        http.formLogin();

        http.authorizeHttpRequests().anyRequest().authenticated();
        return http.build();

    }

    /*@Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userManager=new InMemoryUserDetailsManager();
        UserDetails user= User.withUsername("tom").password(passwordEncoder().encode("tom"))
                .authorities("read").build();
        userManager.createUser(user);
        return userManager;
    }*/
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
