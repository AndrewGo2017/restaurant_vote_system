package ru.javaprojects.restaurant_vote_system.repository;

import ru.javaprojects.restaurant_vote_system.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends BaseRepository<Vote> {
    Vote getByUserAndRestaurantAndDate(int userId, int restaurantId, LocalDate date);
}
