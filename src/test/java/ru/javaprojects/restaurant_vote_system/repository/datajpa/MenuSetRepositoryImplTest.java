package ru.javaprojects.restaurant_vote_system.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaprojects.restaurant_vote_system.TestData;
import ru.javaprojects.restaurant_vote_system.model.MenuSet;
import ru.javaprojects.restaurant_vote_system.repository.AbstractBaseRepositoryTest;
import ru.javaprojects.restaurant_vote_system.repository.MenuSetRepository;
import ru.javaprojects.restaurant_vote_system.to.MenuSetTo;

import java.util.Arrays;
import java.util.List;

public class MenuSetRepositoryImplTest extends AbstractBaseRepositoryTest {
    @Autowired
    MenuSetRepository menuSetRepository;

    @Test
    public void delete() throws Exception {
        menuSetRepository.delete(1);
        List<MenuSet> actual = menuSetRepository.getAll();
        List<MenuSet> expected = Arrays.asList(TestData.MENU_SET2, TestData.MENU_SET3, TestData.MENU_SET4);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void create() throws Exception {
        menuSetRepository.save(new MenuSetTo( 2, 2, 1));
        List<MenuSet> actual = menuSetRepository.getAll();
        List<MenuSet> expected = Arrays.asList(TestData.MENU_SET1, TestData.MENU_SET2, TestData.MENU_SET3, TestData.MENU_SET4, TestData.MENU_SET_NEW);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void get() throws Exception {
        MenuSet actual = menuSetRepository.get(4);
        MenuSet expected = TestData.MENU_SET4;
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void getAll() throws Exception {
        List<MenuSet> actual = menuSetRepository.getAll();
        List<MenuSet> expected = Arrays.asList(TestData.MENU_SET1, TestData.MENU_SET2, TestData.MENU_SET3, TestData.MENU_SET4);
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    @Test
    public void update() throws Exception{
        MenuSet updated = new MenuSet(TestData.MENU_SET1);
        updated.setDay(7);
        menuSetRepository.save(updated);
        assertThat(menuSetRepository.get(TestData.MENU_SET1.getId())).isEqualToComparingFieldByField(updated);
    }

}