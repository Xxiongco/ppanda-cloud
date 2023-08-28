package com.panda.springboot9001.feign.impl;

import com.panda.springboot9001.domain.Person;
import com.panda.springboot9001.feign.Panda9002Server;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@Component
public class Panda9002ServerImpl implements Panda9002Server {

    @Override
    public List<Person> test() {
        log.error("get msg is error");
        return new ArrayList<>();
    }
}
