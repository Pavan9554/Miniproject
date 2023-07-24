package com.miniproject.service.impl;

import com.miniproject.entity.Registration;
import com.miniproject.entity.Role;
import com.miniproject.entity.User;
import com.miniproject.payloadDto.RegistrationDto;
import com.miniproject.payloadDto.UserDto;
import com.miniproject.repository.RoleRepository;
import com.miniproject.repository.UserRepository;
import com.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private ModelMapper mapper;
    @Override
    public void createUser(UserDto userDto) {

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(user.getName());
        user.setPassword(user.getPassword());

        //this will provide 1=ROLE_USER 2=ROLE_ADMIN by hardcoding the value
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN").get();

        user.setRoles(Collections.singleton(roleAdmin));

        userRepository.save(user);
//        User user = mapToEntity(userDto);
//        userRepository.save(user);

    }
    public User mapToEntity(UserDto userDto){
        User map = mapper.map(userDto, User.class);
        return map;
    }

}
