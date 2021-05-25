package com.edafa.demo.security;


import com.edafa.demo.user.UserAuthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.edafa.demo.security.AppUserRole.ADMIN;
import static com.edafa.demo.security.AppUserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    protected final PasswordEncoder passwordEncoder;
    @Autowired
    private UserAuthHandler UserAuthHandler;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index")
                .permitAll()
                .antMatchers("/api/students").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successHandler(UserAuthHandler);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails ahmedUser = User.builder()
                .username("ahmed")
                .password(passwordEncoder.encode("123"))
                .roles(STUDENT.name()).build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles(ADMIN.name()).build();

        return new InMemoryUserDetailsManager(
            ahmedUser,adminUser
        );
    }
}
