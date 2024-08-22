package ru.zaroslikov.coffees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zaroslikov.coffees.models.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
     List<Coffee> findByName(String name);
}
