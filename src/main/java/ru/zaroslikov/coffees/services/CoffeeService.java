package ru.zaroslikov.coffees.services;


import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.zaroslikov.coffees.dto.CoffeeDTO;
import ru.zaroslikov.coffees.dto.CoffeeDTOO;
import ru.zaroslikov.coffees.models.Coffee;
import ru.zaroslikov.coffees.repositories.CoffeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
//    public final CoffeeDtoRepository coffeeDtoRepository;

    public CoffeeService(CoffeeRepository coffeeRepository
//                         ,CoffeeDtoRepository coffeeDtoRepository
    ) {
        this.coffeeRepository = coffeeRepository;
//        this.coffeeDtoRepository = coffeeDtoRepository;
    }

    public List<CoffeeDTOO> findAll() {
        return coffeeRepository.findAllNameSumCount();
    }

    public Coffee findOne(int id) {
        Optional<Coffee> foundCoffee = coffeeRepository.findById(id);
        return foundCoffee.orElse(null);
    }

    @Transactional
    public ResponseEntity<Coffee> save(Coffee coffee) {
        return new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<Coffee> put(Coffee coffee, int id) {
        return (!coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
    }

    @Transactional
    public void delete(int id) {
        coffeeRepository.delete(findOne(id));
    }

}
