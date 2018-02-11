package ru.javaprojects.restaurant_vote_system.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "MENU_SETS")
public class MenuSet extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lunch_menu_id", referencedColumnName = "ID")
    private LunchMenu lunchMenu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", referencedColumnName = "ID")
    private Dish dishes;

    @Column(name = "day")
    @Min(1)
    @Max(7)
    private Integer day;

    public MenuSet() {
    }

    public MenuSet(MenuSet menuSet) {
        this(menuSet.getId(), menuSet.getLunchMenu(), menuSet.getDishes(), menuSet.getDay());
    }

    public MenuSet(LunchMenu lunchMenu, Dish dishes, Integer day) {
        super();
        this.lunchMenu = lunchMenu;
        this.dishes = dishes;
        this.day = day;
    }

    public MenuSet(Integer id, LunchMenu lunchMenu, Dish dishes, Integer day) {
        super(id);
        this.lunchMenu = lunchMenu;
        this.dishes = dishes;
        this.day = day;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Dish getDishes() {
        return dishes;
    }

    public void setDishes(Dish dishes) {
        this.dishes = dishes;
    }
}
