package ru.zaroslikov.coffees.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
}
