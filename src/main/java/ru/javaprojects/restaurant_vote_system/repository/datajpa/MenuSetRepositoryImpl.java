package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.MenuSet;
import ru.javaprojects.restaurant_vote_system.repository.MenuSetRepository;
import ru.javaprojects.restaurant_vote_system.to.MenuDetails;
import ru.javaprojects.restaurant_vote_system.to.MenuSetTo;

import java.util.List;

@Repository
public class MenuSetRepositoryImpl implements MenuSetRepository {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    MenuSetCrudRepository repository;

    @Autowired
    LunchMenuCrudRepository lunchMenuCrudRepository;

    @Autowired
    DishCrudRepository dishCrudRepository;
    
    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public MenuSet save(MenuSet entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public MenuSet save(MenuSetTo entity) {
        MenuSet menuSet = new MenuSet(
                entity.getId(),
                lunchMenuCrudRepository.getOne(entity.getLunchMenuId()),
                dishCrudRepository.getOne(entity.getDishId()),
                entity.getDay());

        repository.save(menuSet);

        return menuSet;
    }

    @Override
    public List<MenuSet> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public MenuSet get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MenuDetails> getMenuDetails(int lunchMenuId) {
        return repository.getMenuDetails(lunchMenuId);
    }
}
