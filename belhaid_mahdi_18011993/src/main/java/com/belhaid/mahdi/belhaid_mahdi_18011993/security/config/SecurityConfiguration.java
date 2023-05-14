package com.belhaid.mahdi.belhaid_mahdi_18011993.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;


import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Permission.ADMIN_READ;
import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Permission.MANAGER_READ;
import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Role.ADMIN;
import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Role.MANAGER;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.headers()
            .frameOptions()
            .sameOrigin()
                    .disable();
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(

                         "/h2-console/**",
                "/api/v1/auth/**"





        )
          .permitAll()
            .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())


            .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())







        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}
