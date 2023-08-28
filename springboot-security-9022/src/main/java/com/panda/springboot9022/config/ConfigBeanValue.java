package com.panda.springboot9022.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfigBeanValue {

    @Value("${panda.name}")
    private String name;

}