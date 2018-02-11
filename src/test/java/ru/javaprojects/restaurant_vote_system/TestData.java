package ru.javaprojects.restaurant_vote_system;

import ru.javaprojects.restaurant_vote_system.model.*;

public class TestData {
    private static final Role ROLE1 = new Role(1, "USER_ADMIN");
    private static final Role ROLE2 = new Role(2, "USER_REGULAR");

    public static final User USER1 = new User(1, "User1", "user1@gmail.com", "password1", ROLE1);
    public static final User USER2 = new User(2, "User2", "user2@gmail.com", "password2", ROLE2);
    public static final User USER_NEW = new User(3, "new user", "new email", "new password", ROLE2);

    public static final LunchMenu LUNCH_MENU1 = new LunchMenu(1, "menu1");
    public static final LunchMenu LUNCH_MENU2 = new LunchMenu(2, "menu2");
    public static final LunchMenu LUNCH_MENU_NEW = new LunchMenu(3,"new menu");

    public static final Dish DISH1 = new Dish(1, "dish1", 10000);
    public static final Dish DISH2 = new Dish(2, "dish2", 100000);
    public static final Dish DISH_NEW = new Dish(3, "new dish", 100000);

    public static final Restaurant RESTAURANT1 = new Restaurant(1, "restaurant1", LUNCH_MENU1, 0);
    public static final Restaurant RESTAURANT2 = new Restaurant(2, "restaurant2", LUNCH_MENU1, 0);
    public static final Restaurant RESTAURANT_NEW = new Restaurant(3, "new restaurant",LUNCH_MENU1, 0);
    public static final Restaurant RESTAURANT_SET_RATING = new Restaurant(1, "restaurant1",LUNCH_MENU1, 1);

    public static final MenuSet MENU_SET1 = new MenuSet(1, LUNCH_MENU1, DISH1, 1);
    public static final MenuSet MENU_SET2 = new MenuSet(2, LUNCH_MENU1, DISH2, 1);
    public static final MenuSet MENU_SET3 = new MenuSet(3, LUNCH_MENU1, DISH1, 2);
    public static final MenuSet MENU_SET4 = new MenuSet(4, LUNCH_MENU1, DISH1, 3);
    public static final MenuSet MENU_SET_NEW = new MenuSet(5, LUNCH_MENU2,DISH2, 1);

}



