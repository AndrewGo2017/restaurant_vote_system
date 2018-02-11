package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.User;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> getByEmail(@Param("email") String email);
}
