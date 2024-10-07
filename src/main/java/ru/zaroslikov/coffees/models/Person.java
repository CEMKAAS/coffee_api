package ru.zaroslikov.coffees.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usermane;
    private String password;
}
