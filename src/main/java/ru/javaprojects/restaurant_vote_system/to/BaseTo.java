package ru.javaprojects.restaurant_vote_system.to;

import ru.javaprojects.restaurant_vote_system.model.PersistentEntity;

public class BaseTo implements PersistentEntity{
    protected Integer id;

    public BaseTo() {
    }

    public BaseTo(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
