package com.panda.springboot9001.feign;

import com.panda.springboot9001.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "panda-provider", path = "/panda-provider")
public interface Panda9002Server {

    @GetMapping("/test/hello")
    List<Person> test();
}
