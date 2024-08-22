package ru.zaroslikov.coffees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Coffee {
    @Id
    private int id;
    private String name;
    private int count;
}
