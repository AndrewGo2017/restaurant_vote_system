package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.LunchMenu;

public interface LunchMenuCrudRepository extends JpaRepository<LunchMenu, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM LunchMenu l WHERE l.id=:id")
    int delete(@Param("id") int id);
}
