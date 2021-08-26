package com.example.springproject1.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")//Se aclara el nombre de la tabla para que no ocurran errores con las queries(mas que nada en windows y en mac)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(length = 50)
    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    //@Column(name = "username", nullable = false, length = 50, unique = true)
    //private String username;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(unique = true)
    private String phone;

}
