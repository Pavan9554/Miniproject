package com.miniproject.service;

import com.miniproject.payloadDto.RegistrationDto;

public interface RegistrationService {
    RegistrationDto createRegistration(RegistrationDto registrationDto);

    RegistrationDto getPostById(long id);

    RegistrationDto updateRegistration(RegistrationDto registrationDto, long id);

    void deleteById(long id);

    void deleteUserByLastName(String lastName);
}
