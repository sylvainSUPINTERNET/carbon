package com.carbon.apicarbon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


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
        .cors().and() // cors load CorsConfiguration bean by default
        .logout(l -> l.logoutSuccessUrl("/").permitAll())
        .authorizeRequests(a -> a.antMatchers("/", "/error", "/webjars/**", "/oauth2/authorization/github", "/oauth2/authorization/facebook", "/oauth2/authorization/gmail", "/graphiql", "/graphql", "/vendor/**","/test").permitAll()
        .anyRequest().authenticated())
        //.csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .csrf().disable() // csrf enable block the PUT / POST request made by another origin, just disable this... 
        .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
        .oauth2Login()
        .successHandler(successHandler());
    }


    @Bean
    public AuthSuccessHandler successHandler() {
        return new AuthSuccessHandler();
    }

}



