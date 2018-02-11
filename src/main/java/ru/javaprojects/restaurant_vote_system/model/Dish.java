package ru.javaprojects.restaurant_vote_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name = "DISHES")
public class Dish extends AbstractNamedEntity{
    @Column(name = "price")
    @Min(1)
    private Integer price;

    public Dish(){
    }

    public Dish(Dish dish){
        this(dish.getId(), dish.getName(), dish.getPrice());
    }

    public Dish(String name, Integer price) {
        super(name);
        this.price = price;
    }

    public Dish(Integer id, String name, Integer price) {
        super(id, name);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
