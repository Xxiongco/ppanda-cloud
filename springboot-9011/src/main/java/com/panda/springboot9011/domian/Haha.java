package com.panda.springboot9011.domian;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Haha {

    private String name;

    private Integer age;
}
