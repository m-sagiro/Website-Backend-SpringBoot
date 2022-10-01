package com.msagiroglu.backendspringboot.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msagiroglu.backendspringboot.model.Role;
import com.msagiroglu.backendspringboot.model.User;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@UtilityClass
public class AuthenticationUtilities {
    public void handleAndSendError(HttpServletResponse response, Exception exception, HttpStatus status) throws IOException {
        response.setHeader("error", exception.getMessage());
        response.setStatus(status.value());
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }

    public String createAccessToken(HttpServletRequest request, Algorithm algorithm, User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .sign(algorithm);
    }

    public String createAccessToken(HttpServletRequest request, Algorithm algorithm, org.springframework.security.core.userdetails.User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
}
