package com.bylearning.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.bylearning.spring")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}
