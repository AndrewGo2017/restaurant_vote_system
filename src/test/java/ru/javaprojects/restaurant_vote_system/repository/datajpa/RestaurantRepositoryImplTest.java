package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaprojects.restaurant_vote_system.TestData;
import ru.javaprojects.restaurant_vote_system.model.Restaurant;
import ru.javaprojects.restaurant_vote_system.repository.AbstractBaseRepositoryTest;
import ru.javaprojects.restaurant_vote_system.repository.RestaurantRepository;

import ru.javaprojects.restaurant_vote_system.to.RestaurantTo;

import java.util.Arrays;
import java.util.List;

public class RestaurantRepositoryImplTest extends AbstractBaseRepositoryTest {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void delete() throws Exception {
        restaurantRepository.delete(1);
        List<Restaurant> actual = restaurantRepository.getAll();
        List<Restaurant> expected = Arrays.asList(TestData.RESTAURANT2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void create() throws Exception {
        restaurantRepository.save(new RestaurantTo( "new restaurant", 1));
        List<Restaurant> actual = restaurantRepository.getAll();
        List<Restaurant> expected = Arrays.asList(TestData.RESTAURANT1, TestData.RESTAURANT2, TestData.RESTAURANT_NEW);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void get() throws Exception {
        Restaurant actual = restaurantRepository.get(1);
        Restaurant expected = TestData.RESTAURANT1;
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "lunchMenu");
    }

    @Test
    public void getAll() throws Exception {
        List<Restaurant> actual = restaurantRepository.getAll();
        List<Restaurant> expected = Arrays.asList(TestData.RESTAURANT1, TestData.RESTAURANT2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void update() throws Exception{
        Restaurant updated = new Restaurant(TestData.RESTAURANT1);
        updated.setName("updated name");
        updated.setRating(1);
        restaurantRepository.save(updated);
        assertThat(restaurantRepository.get(TestData.RESTAURANT1.getId())).isEqualToIgnoringGivenFields(updated);
    }

    @Test
    public void setRating() throws Exception {
        restaurantRepository.setRating(1,1);
        Restaurant actual = restaurantRepository.get(1);
        assertThat(actual).isEqualToIgnoringGivenFields(TestData.RESTAURANT_SET_RATING);
    }
}