package ru.javaprojects.restaurant_vote_system.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant extends AbstractNamedEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lunch_menu_id")
    private LunchMenu lunchMenu;

    @Column(name = "rating")
    private Integer rating = 0;

    public Restaurant() {
    }

    public Restaurant(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), restaurant.getLunchMenu(), restaurant.getRating());
    }


    public Restaurant(String name, LunchMenu lunchMenu, Integer rating) {
        super(name);
        this.lunchMenu = lunchMenu;
        this.rating = rating;
    }

    public Restaurant(Integer id, String name, LunchMenu lunchMenu, Integer rating) {
        super(id, name);
        this.lunchMenu = lunchMenu;
        this.rating = rating;
    }

    public Restaurant(String name, LunchMenu lunchMenu) {
        super(name);
        this.lunchMenu = lunchMenu;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
