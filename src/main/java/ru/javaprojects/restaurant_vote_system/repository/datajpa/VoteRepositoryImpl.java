package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javaprojects.restaurant_vote_system.model.User;
import ru.javaprojects.restaurant_vote_system.model.Vote;
import ru.javaprojects.restaurant_vote_system.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    VoteCrudRepository repository;

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Vote save(Vote entity) {
        return repository.save(entity);
    }

    @Override
    public List<Vote> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public Vote get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vote getByUserAndRestaurantAndDate(int userId, int restaurantId, LocalDate date) {
        return repository.getByUserAndRestaurantAndDate(userId, restaurantId, date).orElse(null);
    }
}