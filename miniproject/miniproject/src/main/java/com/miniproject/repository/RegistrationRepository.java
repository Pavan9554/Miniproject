package com.miniproject.repository;

import com.miniproject.entity.Registration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<Registration> findByLastName(String lastName);
}
