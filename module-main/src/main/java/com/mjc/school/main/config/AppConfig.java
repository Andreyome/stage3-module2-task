package com.mjc.school.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.mjc.school.*")
@EnableAspectJAutoProxy
public class AppConfig {

}
