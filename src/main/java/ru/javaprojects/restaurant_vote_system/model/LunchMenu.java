package ru.javaprojects.restaurant_vote_system.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LUNCH_MENU")
public class LunchMenu extends AbstractNamedEntity {
    public LunchMenu() {
    }

    public LunchMenu(LunchMenu lunchMenu) {
        this(lunchMenu.getId(), lunchMenu.getName());
    }

    public LunchMenu(Integer id, String name) {
        super(id, name);
    }

    public LunchMenu(String name) {
        super(name);
    }
}
