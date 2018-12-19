package com.ex.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by hanaijun on 2018/12/19
 */
@Data
public class User {

    private Long id;

    private String name;

    private String age;

    private LocalDateTime createTime;
}
