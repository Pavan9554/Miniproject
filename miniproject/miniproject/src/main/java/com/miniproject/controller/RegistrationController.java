package com.miniproject.controller;

import com.miniproject.payloadDto.RegistrationDto;
import com.miniproject.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    //http://localhost:8080/api/Registration
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RegistrationDto>  createPost(@RequestBody RegistrationDto registrationDto){
        RegistrationDto dto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    //http://localhost:8080/api/Registration/1
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getPostById(@PathVariable("id") long id){
        return ResponseEntity.ok(registrationService.getPostById(id));
    }

    //http://localhost:8080/api/Registration/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDto> updatePost(@RequestBody RegistrationDto registrationDto,@PathVariable("id") long id){
        RegistrationDto dto = registrationService.updateRegistration(registrationDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8080/api/Registration/1
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        registrationService.deleteById(id);
        return new ResponseEntity<>("Post entity delete successfully.",HttpStatus.OK);
    }
    //http://localhost:8080/api/Registration/lastName
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{lastName}")
    public ResponseEntity<String> deleteUserByLastName(@PathVariable String lastName) {
        registrationService.deleteUserByLastName(lastName);
        return new ResponseEntity<>("the last name  have been deleted successfully.", HttpStatus.OK);
    }
}
