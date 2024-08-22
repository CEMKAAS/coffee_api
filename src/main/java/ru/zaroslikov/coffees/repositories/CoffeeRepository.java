package ru.zaroslikov.coffees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zaroslikov.coffees.models.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
