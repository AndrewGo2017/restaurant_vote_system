package ru.javaprojects.restaurant_vote_system.repository;

import ru.javaprojects.restaurant_vote_system.model.User;
import ru.javaprojects.restaurant_vote_system.to.UserTo;

public interface UserRepository extends BaseRepository<User> {
    User getByEmail(String email);

    User save(UserTo entity);
}
