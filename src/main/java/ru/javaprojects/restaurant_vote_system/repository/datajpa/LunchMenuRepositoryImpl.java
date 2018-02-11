package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javaprojects.restaurant_vote_system.model.LunchMenu;
import ru.javaprojects.restaurant_vote_system.repository.LunchMenuRepository;

import java.util.List;

@Repository
public class LunchMenuRepositoryImpl implements LunchMenuRepository {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    LunchMenuCrudRepository repository;
    
    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public LunchMenu save(LunchMenu entity) {
        return repository.save(entity);
    }

    @Override
    public List<LunchMenu> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public LunchMenu get(int id) {
        return repository.findById(id).orElse(null);
    }
}
