package ru.zaroslikov.coffees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zaroslikov.coffees.models.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
