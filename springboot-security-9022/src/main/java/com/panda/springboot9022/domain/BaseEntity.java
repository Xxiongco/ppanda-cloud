package com.panda.springboot9022.domain;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseEntity {

    @NotBlank
    private String name;
}
