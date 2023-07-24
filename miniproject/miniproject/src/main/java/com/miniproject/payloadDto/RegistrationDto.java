package com.miniproject.payloadDto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class RegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
}
