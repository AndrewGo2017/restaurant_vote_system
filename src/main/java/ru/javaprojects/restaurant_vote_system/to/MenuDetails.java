package ru.javaprojects.restaurant_vote_system.to;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class MenuDetails implements Serializable{
    @Min(1)
    @Max(7)
    private Integer day;

    @NotBlank
    private String dishName;

    @Min(1)
    private Integer dishPrice;

    public MenuDetails(){}

    public MenuDetails(Integer day, String dishName, Integer dishPrice) {
        this.day = day;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Integer dishPrice) {
        this.dishPrice = dishPrice;
    }
}
