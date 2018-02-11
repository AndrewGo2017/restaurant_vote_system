package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import ru.javaprojects.restaurant_vote_system.TestData;
import ru.javaprojects.restaurant_vote_system.model.LunchMenu;
import ru.javaprojects.restaurant_vote_system.repository.AbstractBaseRepositoryTest;
import ru.javaprojects.restaurant_vote_system.repository.LunchMenuRepository;

import java.util.Arrays;
import java.util.List;


public class LunchMenuRepositoryImplTest extends AbstractBaseRepositoryTest {
    @Autowired
    LunchMenuRepository lunchMenuRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void delete() throws Exception {
        lunchMenuRepository.delete(1);
        List<LunchMenu> actual = lunchMenuRepository.getAll();
        List<LunchMenu> expected = Arrays.asList(TestData.LUNCH_MENU1);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void create() throws Exception {
        LunchMenu lunchMenu = lunchMenuRepository.save(new LunchMenu( "new menu"));
        List<LunchMenu> actual = lunchMenuRepository.getAll();
        List<LunchMenu> expected = Arrays.asList(TestData.LUNCH_MENU1, TestData.LUNCH_MENU2, TestData.LUNCH_MENU_NEW);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void get() throws Exception {
        LunchMenu actual = lunchMenuRepository.get(1);
        LunchMenu expected = TestData.LUNCH_MENU1;
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void getAll() throws Exception {
        List<LunchMenu> actual = lunchMenuRepository.getAll();
        List<LunchMenu> expected = Arrays.asList(TestData.LUNCH_MENU1, TestData.LUNCH_MENU2);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void update() throws Exception{
        LunchMenu updated = new LunchMenu(TestData.LUNCH_MENU1);
        updated.setName("updated name");
        lunchMenuRepository.save(updated);
        assertThat(lunchMenuRepository.get(TestData.LUNCH_MENU1.getId())).isEqualToComparingFieldByField(updated);
    }
}