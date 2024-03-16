package com.example.testSpringDataJPA.config;

import com.example.testSpringDataJPA.aspect.UserActionAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public UserActionAspect userActionAspect(){
        return  new UserActionAspect();
    }
}
