package ru.javaprojects.restaurant_vote_system.to;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class MenuSetTo extends BaseTo implements Serializable {

    private Integer lunchMenuId;

    private Integer dishId;

    @Column(name = "day")
    @Min(1)
    @Max(7)
    private Integer day;

    public MenuSetTo() {
    }

    public MenuSetTo(Integer lunchMenuId, Integer dishId, @Min(1) @Max(7) Integer day) {
        this.lunchMenuId = lunchMenuId;
        this.dishId = dishId;
        this.day = day;
    }

    public MenuSetTo(Integer id, Integer lunchMenuId, Integer dishId, @Min(1) @Max(7) Integer day) {
        super(id);
        this.lunchMenuId = lunchMenuId;
        this.dishId = dishId;
        this.day = day;
    }

    public Integer getLunchMenuId() {
        return lunchMenuId;
    }

    public void setLunchMenuId(Integer lunchMenuId) {
        this.lunchMenuId = lunchMenuId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
