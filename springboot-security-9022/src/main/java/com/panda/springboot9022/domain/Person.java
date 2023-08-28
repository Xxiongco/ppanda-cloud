package com.panda.springboot9022.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Person extends BaseEntity{

    @NotBlank(message = "学号不能为空")
    private String num;

    @NotNull
    private BigDecimal grade;

    @Override
    public String toString() {
        return "Person{" +
                "num='" + num + '\'' +
                ", grade=" + grade +
                ", name=" + getName() +
                '}';
    }
}
