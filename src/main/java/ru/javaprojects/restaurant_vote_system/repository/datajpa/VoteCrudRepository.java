package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VoteCrudRepository extends org.springframework.data.jpa.repository.JpaRepository<Vote, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT v FROM Vote v WHERE v.user.id=:userId AND v.restaurant.id=:restaurantId AND v.date=:date ORDER BY v.date DESC")
    Optional<Vote> getByUserAndRestaurantAndDate(@Param("userId") int userId, @Param("restaurantId") int restaurantId, @Param("date") LocalDate date);
}
