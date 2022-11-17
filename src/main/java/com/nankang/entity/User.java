package com.nankang.entity;


import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

    private String id;
    @NotNull(message = "姓名不能为空")
    @Size(min = 1,max = 50)
    private String userName;
    @Size(min = 1,max = 20)
    private String tel;
    @NotNull(message = "age 不能为空")
    private Integer age;
}
