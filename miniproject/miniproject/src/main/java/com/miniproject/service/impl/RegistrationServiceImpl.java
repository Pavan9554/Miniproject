package com.miniproject.service.impl;

import com.miniproject.entity.Registration;
import com.miniproject.exception.ResourceNotFoundException;
import com.miniproject.payloadDto.RegistrationDto;
import com.miniproject.repository.RegistrationRepository;
import com.miniproject.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;
    private ModelMapper mapper;


    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        Registration registration = mapToEntity(registrationDto);
        Registration registrationEntity = registrationRepository.save(registration);
        RegistrationDto dto = mapToDto(registrationEntity);
        return dto;
    }

    @Override
    public RegistrationDto getPostById(long id) {
        Registration registration1 = registrationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registration", "id", id)
        );
        return mapToDto(registration1);
    }

    @Override
    public RegistrationDto updateRegistration(RegistrationDto registrationDto, long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registration", "id", id)
        );

        registration.setFirstName(registrationDto.getFirstName());
        registration.setLastName(registrationDto.getLastName());
        registration.setEmail(registrationDto.getEmail());
        Registration newRegistration = registrationRepository.save(registration);
        return mapToDto(newRegistration);
    }

    @Override
    public void deleteById(long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public void deleteUserByLastName(String lastName) {
        List<Registration> byLastName = registrationRepository.findByLastName(lastName);
        registrationRepository.deleteAll(byLastName);
    }
//

    public Registration mapToEntity(RegistrationDto registrationDto){
        Registration  registration = mapper.map(registrationDto, Registration.class);
        return registration;
    }
      public RegistrationDto mapToDto(Registration registration){
            RegistrationDto dto = mapper.map(registration, RegistrationDto.class);
            return dto;
}

}
