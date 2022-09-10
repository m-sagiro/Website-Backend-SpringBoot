package com.msagiroglu.backendspringboot.security;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

//TODO Custom DSL
public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

    @Override
    public void init(HttpSecurity http) throws Exception {
        // any method that adds another configurer
        // must be done in the init method
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http
                .authorizeRequests()
                .antMatchers("/api/login/**", "/api/token/refresh/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(GET, "/api/**").hasAnyAuthority("ROLE_ADMIN");
//                .antMatchers("/user/all").hasRole("ADMIN");
//                .antMatchers("/hello").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        ApplicationContext context = http.getSharedObject(ApplicationContext.class);
//        AuthenticationManager authenticationManager =
//                http.getSharedObject(AuthenticationManager.class);
//        CustomAuthenticationFilter filter =
//                new CustomAuthenticationFilter(authenticationManager, accessTokenExpiredInDays, refreshTokenExpiredInDays, jwtSecret);
//        filter.setFilterProcessesUrl("/api/login");
//        http.addFilter(filter);

        // here we lookup from the ApplicationContext. You can also just create a new instance.
//        MyFilter myFilter = context.getBean()
//        myFilter.setFlag(flag);
//        http.addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);
    }

    public CustomDsl flag(boolean value) {
        return this;
    }

    public static CustomDsl customDsl() {
        return new CustomDsl();
    }
}
