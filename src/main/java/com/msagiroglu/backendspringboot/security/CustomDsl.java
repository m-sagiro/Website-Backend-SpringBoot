package com.msagiroglu.backendspringboot.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

    @Override
    public void init(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(
                        "/api/login/**",
                        "/api/token/refresh/**",
                        "/api/blogs",
                        "/api/blog/get/**",
                        "/api/email/send",
                        "/**.eot", "/**.woff2",
                        "/**.ttf", "/**.woff",
                        "/**.html", "/**.js", "/**.css",
                        "/**.map", "/assets/**",
                        "/", "/error",
                        "/entry", "/home", "/about", "/blog/**", "/contact", "/logout"
                ).permitAll()
                .antMatchers("/api/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

    }





}
