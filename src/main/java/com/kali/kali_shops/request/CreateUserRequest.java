package com.kali.kali_shops.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lstName;
    private String email;
    private String password;
}
