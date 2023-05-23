package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class bkpProjectConfig {

    //@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         *  Below is the custom security configurations
         */

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                            .requestMatchers("/notices", "/contact", "/registerUser").permitAll();
                    //http.csrf(csrf - > csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                    //https://www.javadevjournal.com/spring-security/spring-security-csrf-token/
                    // ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
                });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain) http.build();

        /**
         *  Configuration to deny all the requests
         */
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/

        /**
         *  Configuration to permit all the requests
         */
        /*http.authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/
    }

    //@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

     /* @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        *//**
     * Approach 1: with withDefaultPasswordEncoder
     * @return
     *//*
        //Below withDefaultPasswordEncoder not working after passwordEncoder bean declaration
       // UserDetails user1 = User.withDefaultPasswordEncoder().username("naresh1").password("12345").authorities("admin").build();
       // UserDetails user2 = User.withDefaultPasswordEncoder().username("naresh2").password("12345").authorities("user").build();

        *//**
     * Approach 2: with passwordEncoder Bean
     * @return
     *//*
        UserDetails user3 = User.withUsername("naresh3").password("12345").authorities("admin").build();
        UserDetails user4 = User.withUsername("naresh4").password("12345").authorities("admin").build();
       // return new InMemoryUserDetailsManager(user1,user2,user3,user4);
        return new InMemoryUserDetailsManager(user3,user4);
    }*/
    /*@Bean
    public UserDetailsService userDetailsService(DataSource source) {
        return new JdbcUserDetailsManager(source);
    }*/

}
