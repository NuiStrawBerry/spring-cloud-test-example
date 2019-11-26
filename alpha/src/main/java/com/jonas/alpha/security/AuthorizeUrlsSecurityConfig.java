package com.jonas.alpha.security;

import com.jonas.alpha.service.UserDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthorizeUrlsSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDService userDService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .anonymous().and()
                .authorizeRequests()
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                    .antMatchers("/health").anonymous()
                    .antMatchers("/health").permitAll()
                .and().userDetailsService(userDService)
                    .formLogin()

//                        .loginPage("")
//                        .successForwardUrl()
//                        .failureForwardUrl()
//                        .passwordParameter()
//                        .usernameParameter()
//                .and()
//        .authenticationProvider()
//        .userDetailsService()
//        .addFilter()
//        .addFilterAfter()
//        .requestMatchers()
//                .antMatchers()
//        .mvcMatchers()



        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("jonas").roles("USER")
                .and().withUser("admin").password("jonas").roles("ADMIN", "USER");
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
