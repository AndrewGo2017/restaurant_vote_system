package ru.javaprojects.restaurant_vote_system.controller.regular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javaprojects.restaurant_vote_system.model.Restaurant;
import ru.javaprojects.restaurant_vote_system.repository.MenuSetRepository;
import ru.javaprojects.restaurant_vote_system.repository.RestaurantRepository;
import ru.javaprojects.restaurant_vote_system.security.Authorization;
import ru.javaprojects.restaurant_vote_system.to.MenuDetails;

import java.util.List;

@RestController
@RequestMapping("/rest/regular/restaurant_info")
public class RestaurantInfoController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuSetRepository menuSetRepository;

    @Autowired
    protected RestaurantRepository restaurantRepository;

    @GetMapping(value = "/menu_details/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuDetails> getMenuDetails(@PathVariable("id") Integer lunchMenuId) {
        log.info("getMenuDetails");
        return menuSetRepository.getMenuDetails(lunchMenuId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getRestaurants() {
        log.info("getRestaurants");
        return restaurantRepository.getAll();
    }

    @PutMapping("/vote/{restaurantId}")
    public ResponseEntity changeStatus(@PathVariable("restaurantId") Integer restaurantId) {
        log.info("vote restaurant id " + restaurantId);
        restaurantRepository.setRating(Authorization.id(), restaurantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
