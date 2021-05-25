package com.carbon.apicarbon.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;


// Flow : 
// 1) http://localhost:9999/oauth2/authorization/github to ask authorization for user (link in client)
// 2) If success => transaction to create new user
// 3) if success redirect to localhost:3000 (client) with JSESSIONID (session oauth2) could be edit / use in Postman
// 4) /logout => clear session (POST)

@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter   {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:3000"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            cors.setAllowCredentials(true);
            return cors;
          })
        .and()
        .logout(l -> l.logoutSuccessUrl("/").permitAll())
        .authorizeRequests(a -> a.antMatchers("/", "/error", "/webjars/**", "/oauth2/authorization/github", "/oauth2/authorization/facebook", "/oauth2/authorization/gmail").permitAll()
        .anyRequest().authenticated())
        .csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
        .oauth2Login()
        .successHandler(successHandler());
    }

    @Bean
    public AuthSuccessHandler successHandler() {
        return new AuthSuccessHandler();
    }

}



