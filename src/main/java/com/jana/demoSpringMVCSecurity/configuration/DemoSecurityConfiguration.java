package com.jana.demoSpringMVCSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )

                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())
                .logout(logout->logout.permitAll())
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();

    }

     /*  @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jana= User.builder()
                .username("jana")
                .password("{noop}jana123")
                .roles("EMPLOYEE")
                .build();
        UserDetails shiva=User.builder()
                .username("shiva")
                .password("{noop}shiva123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails vardan=User.builder()
                .username("vardan")
                .password("{noop}vardan123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(jana,shiva,vardan);


    }*/

}
