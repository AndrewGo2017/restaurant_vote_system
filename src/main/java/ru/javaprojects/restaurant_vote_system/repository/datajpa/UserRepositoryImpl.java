package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaprojects.restaurant_vote_system.model.User;
import ru.javaprojects.restaurant_vote_system.repository.UserRepository;
import ru.javaprojects.restaurant_vote_system.security.Authorization;
import ru.javaprojects.restaurant_vote_system.to.UserTo;

import java.util.List;

@Repository("security")
public class UserRepositoryImpl implements UserRepository, UserDetailsService {
    private static final Sort SORT_BY_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    UserCrudRepository repository;

    @Autowired
    RoleCrudRepository roleCrudRepository;

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public User save(UserTo entity) {
        User user = new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                roleCrudRepository.getOne(entity.getRoleId())
        );

        repository.save(user);

        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(SORT_BY_ID);
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getByEmail(s);
        if (user == null){
            throw new UsernameNotFoundException("user (email)" + s + " is not found");
        }
        return new Authorization(user);
    }
}
