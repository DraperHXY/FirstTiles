package com.draper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {

    private long id;
    @JsonIgnore
    private long createAt;
    @JsonIgnore
    private long updateAt;

    private String name;

    private String phone;

    private String email;

    private String password;
}
