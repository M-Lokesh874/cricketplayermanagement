package com.ideas2it.cricketplayermanagement.util.config;

import com.ideas2it.cricketplayermanagement.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf()
               .disable()
               .authorizeRequests()
               .antMatchers("/authenticate").permitAll()
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
    }
}
