package com.miniproject.payloadDto;

import lombok.Data;

@Data
public class LoginDto {

    private String usernameOrEmail;
    private String password;
}
