package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import ru.javaprojects.restaurant_vote_system.TestData;
import ru.javaprojects.restaurant_vote_system.model.Dish;
import ru.javaprojects.restaurant_vote_system.repository.AbstractBaseRepositoryTest;
import ru.javaprojects.restaurant_vote_system.repository.DishRepository;


import java.util.Arrays;
import java.util.List;

public class DishRepositoryImplTest extends AbstractBaseRepositoryTest {
    @Autowired
    DishRepository dishRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void delete() throws Exception {
        dishRepository.delete(1);
        List<Dish> actual = dishRepository.getAll();
        List<Dish> expected = Arrays.asList(TestData.DISH1);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void create() throws Exception {
        dishRepository.save(new Dish( "new dish", 100000));
        List<Dish> actual = dishRepository.getAll();
        List<Dish> expected = Arrays.asList(TestData.DISH1, TestData.DISH2, TestData.DISH_NEW);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void findById() throws Exception {
        Dish actual = dishRepository.get(1);
        Dish expected = TestData.DISH1;
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void findAll() throws Exception {
        List<Dish> actual = dishRepository.getAll();
        List<Dish> expected = Arrays.asList(TestData.DISH1, TestData.DISH2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void update() throws Exception{
        Dish updated = new Dish(TestData.DISH1);
        updated.setName("updated name");
        updated.setPrice(100);
        dishRepository.save(updated);
        assertThat(dishRepository.get(TestData.DISH1.getId())).isEqualToComparingFieldByField (updated);
    }
}