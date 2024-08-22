package ru.zaroslikov.coffees.controllers;

import org.springframework.web.bind.annotation.*;
import ru.zaroslikov.coffees.models.Coffee;
import ru.zaroslikov.coffees.services.CoffeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCoffee {

    private final CoffeeService coffeeService;

    public RestCoffee(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }


    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffeeService.findAll();
    }

    @GetMapping("/coffee")
    public String getCoffees1() {
        return " Где кофее";
    }

    @PostMapping("/post")
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        coffeeService.save(coffee);
        return coffee;
    }

}