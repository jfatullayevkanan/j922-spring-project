package com.example.j922springproject.config;

import com.example.j922springproject.service.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
CI/CD
Pipeline
Docker
Kubernetes
Deploy project to aws, google cloud or azure
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
}

    /*
        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http
                .authorizeHttpRequests()
                .antMatchers("/v1/students", "/v1/employees").hasRole("teacher")
                .antMatchers("/v1/students").hasAnyRole("student", "")
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("kanan")
                .password("{noop}kanan123")
                .roles("teacher")
                .and()
                .withUser("hasan")
                .password("{noop}hasan123")
                .roles("student");
    }

     */
