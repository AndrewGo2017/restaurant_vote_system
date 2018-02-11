package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaprojects.restaurant_vote_system.TestData;
import ru.javaprojects.restaurant_vote_system.model.User;
import ru.javaprojects.restaurant_vote_system.repository.AbstractBaseRepositoryTest;
import ru.javaprojects.restaurant_vote_system.repository.UserRepository;
import ru.javaprojects.restaurant_vote_system.to.UserTo;

import java.util.Arrays;
import java.util.List;

public class UserRepositoryImplTest extends AbstractBaseRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void delete() throws Exception {
        userRepository.delete(1);
        List<User> actual = userRepository.getAll();
        List<User> expected = Arrays.asList(TestData.USER2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void create() throws Exception {
        userRepository.save(new UserTo("new user", "new email", "new password", 2));
        List<User> actual = userRepository.getAll();
        List<User> expected = Arrays.asList(TestData.USER1, TestData.USER2, TestData.USER_NEW);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void get() throws Exception {
        User actual = userRepository.get(1);
        User expected = TestData.USER1;
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void getAll() throws Exception {
        List<User> actual = userRepository.getAll();
        List<User> expected = Arrays.asList(TestData.USER1, TestData.USER2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void update() throws Exception{
        User updated = new User(TestData.USER1);
        updated.setEmail("updated email");
        updated.setPassword("updated password");
        updated.setName("updated name");
        userRepository.save(updated);
        assertThat(userRepository.get(TestData.USER1.getId())).isEqualTo(updated);

    }

    @Test
    public void getByEmail() throws Exception {
        User actual = userRepository.getByEmail("user1@gmail.com");
        User expected = TestData.USER1;
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}