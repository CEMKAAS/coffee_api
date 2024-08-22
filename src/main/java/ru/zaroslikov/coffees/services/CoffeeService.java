package ru.zaroslikov.coffees.services;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.zaroslikov.coffees.models.Coffee;
import ru.zaroslikov.coffees.repositories.CoffeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Coffee findOne(int id) {
        Optional<Coffee> foundCoffee = coffeeRepository.findById(id);
        return foundCoffee.orElse(null);
    }

    @Transactional
   public void save(Coffee coffee){
        coffeeRepository.save(coffee);
     }
}
