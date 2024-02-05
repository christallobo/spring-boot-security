package com.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // setting the configuration on the auth object
         auth.inMemoryAuthentication()
                 .withUser("abc")
                 .password("abc123")
                 .roles("USER")
                 //For multiple users
                .and()
                .withUser("foo")
                .password("foo123")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
       // It does nothing but keeps the clear text
        return NoOpPasswordEncoder.getInstance();
    }
}
