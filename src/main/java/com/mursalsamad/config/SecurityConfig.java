package com.mursalsamad.config;

import com.mursalsamad.jwt.AuthEntryPoint;
import com.mursalsamad.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private static final String REGISTER = "/rest/api/register";
    private static final String AUTHENTICATE = "/rest/api/authenticate";
    private static final String REFRESH_TOKEN = "/rest/api/refresh-token";
    @Autowired
    private AuthenticationProvider provider;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;
    @Autowired
    private AuthEntryPoint entryPoint;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(REGISTER,AUTHENTICATE,REFRESH_TOKEN).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(provider)
                .exceptionHandling(point -> point.authenticationEntryPoint(entryPoint))
                .build();
    }
}
