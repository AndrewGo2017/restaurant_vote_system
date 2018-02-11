package ru.javaprojects.restaurant_vote_system.repository;

import ru.javaprojects.restaurant_vote_system.model.Restaurant;
import ru.javaprojects.restaurant_vote_system.to.RestaurantTo;

public interface RestaurantRepository extends BaseRepository<Restaurant> {
    boolean setRating(int userId, int restaurantId);

    Restaurant save(RestaurantTo entity);
}
