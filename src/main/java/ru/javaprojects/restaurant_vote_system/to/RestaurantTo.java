package ru.javaprojects.restaurant_vote_system.to;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class RestaurantTo extends BaseTo implements Serializable {
    @NotBlank
    private String name;

    private Integer lunchMenuId;

    private Integer rating = 0;

    public RestaurantTo(){

    }

    public RestaurantTo(Integer id, String name, Integer lunchMenuId, Integer rating) {
        super(id);
        this.name = name;
        this.lunchMenuId = lunchMenuId;
        this.rating = rating;
    }

    public RestaurantTo(Integer id, String name, Integer lunchMenuId) {
        super(id);
        this.name = name;
        this.lunchMenuId = lunchMenuId;
    }

    public RestaurantTo(String name, Integer lunchMenuId) {
        this.name = name;
        this.lunchMenuId = lunchMenuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLunchMenuId() {
        return lunchMenuId;
    }

    public void setLunchMenuId(Integer lunchMenuId) {
        this.lunchMenuId = lunchMenuId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
