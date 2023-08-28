package com.panda.springboot9001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidateConfig {

    @Bean
    public Validator buildValidate() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
