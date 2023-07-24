package com.miniproject.payloadDto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;

}
