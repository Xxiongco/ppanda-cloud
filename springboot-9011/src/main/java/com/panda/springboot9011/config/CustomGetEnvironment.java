package com.panda.springboot9011.config;


import com.panda.springboot9011.domian.Haha;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomGetEnvironment implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        StandardServletEnvironment environment = (StandardServletEnvironment)applicationContext.getEnvironment();

        PropertySource<?> configurationProperties = environment.getPropertySources().get("configurationProperties");

        Object property = configurationProperties.getProperty("nihao.haha");

        System.out.println(property);

        Binder binder = Binder.get(environment);

        // 这样是可以拿到远程的配置的
        Haha Haha = binder.bind("nihao.haha", Haha.class).get();

        this.applicationContext = applicationContext;
    }
}
