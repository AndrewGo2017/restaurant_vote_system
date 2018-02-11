package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.MenuSet;
import ru.javaprojects.restaurant_vote_system.to.MenuDetails;

import java.util.List;

public interface MenuSetCrudRepository extends JpaRepository<MenuSet, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM MenuSet m WHERE m.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT NEW ru.javaprojects.restaurant_vote_system.to.MenuDetails(ms.day, ms.dishes.name, ms.dishes.price) FROM MenuSet ms WHERE ms.lunchMenu.id=:lunchMenuId")
    List<MenuDetails> getMenuDetails(@Param("lunchMenuId") int lunchMenuId);
}
