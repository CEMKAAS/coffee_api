package ru.zaroslikov.coffees.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zaroslikov.coffees.dto.CoffeeDTO;
import ru.zaroslikov.coffees.dto.CoffeeDTOO;
import ru.zaroslikov.coffees.models.Coffee;
import ru.zaroslikov.coffees.services.CoffeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class RestCoffee {

    private final CoffeeService coffeeService;
    private final ModelMapper modelMapper;

    public RestCoffee(CoffeeService coffeeService, ModelMapper modelMapper) {
        this.coffeeService = coffeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/coffees")
    public List<CoffeeDTOO> getCoffees() {
        return coffeeService.findAll();
    }

    @GetMapping("/coffee")
    public String getCoffees1() {
        return " Где кофее";
    }

    @GetMapping("/coffees/{id}")
    public CoffeeDTO getCoffee(@PathVariable("id") int id) {
        return convertToCoffeeDTO(coffeeService.findOne(id));
    }

    @PostMapping("/coffees")
    public ResponseEntity<Coffee> postCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        return coffeeService.save(convertToCoffee(coffeeDTO));
    }

    private Coffee convertToCoffee(CoffeeDTO coffeeDTO) {
        return modelMapper.map(coffeeDTO, Coffee.class);
    }

    private CoffeeDTO convertToCoffeeDTO(Coffee coffee) {
        return modelMapper.map(coffee, CoffeeDTO.class);
    }

    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        return coffeeService.put(coffee, id);
    }

    @DeleteMapping("/coffees/{id}")
    public ResponseEntity<Coffee> deleteCoffee(@PathVariable int id) {
        coffeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}