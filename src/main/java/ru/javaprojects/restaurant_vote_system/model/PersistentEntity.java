package ru.javaprojects.restaurant_vote_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface PersistentEntity {
    Integer getId();

    void setId(Integer id);

    @JsonIgnore
    default boolean isNew() {
        return getId() == null;
    }
}
