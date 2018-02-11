package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.Restaurant;
import ru.javaprojects.restaurant_vote_system.model.Vote;
import ru.javaprojects.restaurant_vote_system.repository.RestaurantRepository;
import ru.javaprojects.restaurant_vote_system.to.RestaurantTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");
    private static final LocalTime LOCK_TIME = LocalTime.of(11,00);

    @Autowired
    RestaurantCrudRepository repository;

    @Autowired
    VoteCrudRepository voteCrudRepository;

    @Autowired
    UserCrudRepository userCrudRepository;

    @Autowired
    LunchMenuCrudRepository lunchMenuCrudRepository;
    
    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Restaurant save(Restaurant entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public Restaurant save(RestaurantTo entity) {
        Restaurant restaurant = new Restaurant(
                entity.getId(),
                entity.getName(),
                lunchMenuCrudRepository.getOne(entity.getLunchMenuId()),
                entity.getRating()
        );
        repository.save(restaurant);

        return restaurant;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean setRating(int userId, int restaurantId) {
        Vote vote = voteCrudRepository.getByUserAndRestaurantAndDate(userId, restaurantId, LocalDate.now()).orElse(null);
        Restaurant restaurant = repository.getOne(restaurantId);
        if (vote == null){
            restaurant.setRating(restaurant.getRating() + 1);
            voteCrudRepository.save(new Vote(userCrudRepository.getOne(userId), true, LocalDate.now(), repository.getOne(restaurantId)));
        }
        else {
            if (LocalTime.now().isBefore(LOCK_TIME)){
                restaurant.setRating(restaurant.getRating() + (vote.isUp() ? -1 : 1));
                save(restaurant);

                vote.setUp(!vote.isUp());
                voteCrudRepository.save(vote);

                return true;
            }
        }
        return false;
    }
}
