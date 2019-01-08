package com.ycj.reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsServiceImpl;

    SecurityConfiguration(@Autowired UserDetailsServiceImpl userDetailsServiceImpl ){
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/index","/error","/init","/explore").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/homepage").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/image/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/login.json?result=success").failureUrl("/login.json?result=error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index");
    }
}