package ru.zaroslikov.coffees.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CoffeeDTO {
    @Override
    public String toString() {
        return "CoffeeDTO{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public CoffeeDTO() {
    }

    public CoffeeDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String name;
    private int quantity;
}
