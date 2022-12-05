package com.ideas2it.cricketplayermanagement.util.config;

import com.ideas2it.cricketplayermanagement.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate", "/saveUser").permitAll()
                .antMatchers("/saveCricketPlayer",
                        "/getAllCricketPlayers",
                        "/getCricketPlayer/{id}",
                        "deleteCricketPlayer/{id}",
                        "updateCricketPlayer/{id}").hasAuthority("cricketplayer")
                .antMatchers("/saveCricketTeam",
                        "/getAllCricketTeams",
                        "/getCricketTeam/{id}",
                        "deleteTeam/{id}",
                        "updateTeam/{id}").hasAuthority("cricketteam")
                .antMatchers("/saveStats",
                        "/getAllStats",
                        "/getStatsById/{id}",
                        "deleteStats/{id}",
                        "updateStats/{id}").hasAuthority("cricketplayerstats")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
