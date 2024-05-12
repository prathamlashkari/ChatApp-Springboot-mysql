package com.pratham.chatappbackend.config;

import java.util.Arrays;
import java.util.Collection;

import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {

  @SuppressWarnings("removal")
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/**").authenticated()
            .anyRequest().permitAll())
        .addFilterBefore(null, null)
        .csrf().disable()
        .cors().configurationSource(new CorsConfigurationSource() {

          @SuppressWarnings("null")
          @Override
          @Nullable

          public CorsConfiguration getCorsConfiguration(HttpServletRequest arg0) {
            CorsConfiguration cfg = new CorsConfiguration();
            cfg.setAllowedOrigins(Arrays.asList("https://localhost:5173"));
            cfg.setAllowedMethods(Collections.singletonList("*"));
            cfg.setAllowCredentials(true);
            cfg.setExposedHeaders(Arrays.asList("Authorization"));
            cfg.setAllowedHeaders(Collections.singletonList("*"));
            cfg.setMaxAge(3600L);
            return cfg;
          }

        })
        .and().formLogin().and().httpBasic(null);

    return http.build();

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
