package ru.javaprojects.restaurant_vote_system.repository;

import ru.javaprojects.restaurant_vote_system.model.AbstractBaseEntity;

import java.util.List;

public interface  BaseRepository<T extends AbstractBaseEntity>{
    T save(T entity);

    boolean delete(int id);

    List<T> getAll();

    T get(int id);
}
