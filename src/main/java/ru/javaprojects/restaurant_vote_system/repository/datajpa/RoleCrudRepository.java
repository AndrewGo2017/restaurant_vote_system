package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javaprojects.restaurant_vote_system.model.Role;

public interface RoleCrudRepository extends JpaRepository<Role, Integer> {
}
