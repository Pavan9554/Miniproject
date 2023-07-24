package com.miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstname" , nullable = false)
    private String firstName;
    @Column(name="lastname" , nullable = false)
    private String lastName;
    @Column(name="email" , nullable = false)
    private String email;
    @Column(name="number" , nullable = false)
    private String number;
}
