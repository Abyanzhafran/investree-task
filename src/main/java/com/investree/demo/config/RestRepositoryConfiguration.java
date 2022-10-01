package com.investree.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class RestRepositoryConfiguration implements RepositoryRestConfigurer {
    @Autowired
    private WebApplicationContext context;

}
