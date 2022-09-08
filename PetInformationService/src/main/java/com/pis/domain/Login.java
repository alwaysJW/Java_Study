package com.pis.domain;

import lombok.Data;

@Data
public class Login {
    private int id;
    private String email;
    private String password;
    private String name;
    private int key;
}
