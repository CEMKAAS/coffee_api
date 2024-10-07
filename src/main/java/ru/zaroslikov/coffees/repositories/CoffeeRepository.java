package ru.zaroslikov.coffees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.zaroslikov.coffees.dto.CoffeeDTO;
import ru.zaroslikov.coffees.dto.CoffeeDTOO;
import ru.zaroslikov.coffees.models.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
     List<Coffee> findByName(String name);

     @Query(value = "SELECT name, SUM(Coffee.quantity) AS quantity from Coffee group by name order by quantity DESC",
             nativeQuery = true)
     List<CoffeeDTOO> findAllNameSumCount();
}
