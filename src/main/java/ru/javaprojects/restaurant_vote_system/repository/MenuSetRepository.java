package ru.javaprojects.restaurant_vote_system.repository;

import ru.javaprojects.restaurant_vote_system.model.MenuSet;
import ru.javaprojects.restaurant_vote_system.to.MenuDetails;
import ru.javaprojects.restaurant_vote_system.to.MenuSetTo;

import java.util.List;

public interface MenuSetRepository extends BaseRepository<MenuSet> {
    MenuSet save(MenuSetTo entity);

    List<MenuDetails> getMenuDetails(int lunchMenuId);
}
