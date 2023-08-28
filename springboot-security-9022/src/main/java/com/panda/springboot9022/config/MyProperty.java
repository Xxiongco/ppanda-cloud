package com.panda.springboot9022.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "test")
@Component
@PropertySource(value = "myProperties.properties")
@Data
public class MyProperty {

    String name;

}
