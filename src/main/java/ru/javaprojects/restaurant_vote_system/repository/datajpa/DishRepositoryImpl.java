package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javaprojects.restaurant_vote_system.model.Dish;
import ru.javaprojects.restaurant_vote_system.repository.DishRepository;

import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    DishCrudRepository repository;

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Dish save(Dish entity) {
        return repository.save(entity);
    }

    @Override
    public List<Dish> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public Dish get(int id) {
        return repository.findById(id).orElse(null);
    }
}
