package ru.javaprojects.restaurant_vote_system.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaprojects.restaurant_vote_system.model.Restaurant;
import ru.javaprojects.restaurant_vote_system.repository.RestaurantRepository;
import ru.javaprojects.restaurant_vote_system.to.RestaurantTo;

import java.net.URI;
import java.util.List;

import static ru.javaprojects.restaurant_vote_system.controller.admin.RestaurantRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
public class RestaurantRestController {
    static final String REST_URL = "/rest/admin/restaurant";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    RestaurantRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody RestaurantTo restaurant) {
        Restaurant created = repository.save(restaurant);
        log.info("create id {}", created.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody RestaurantTo restaurant) {
        Restaurant updated = repository.save(restaurant);
        log.info("update id {}", updated.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") Integer id) {
        log.info("get id {}", id);
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        log.info("delete id {}", id);
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        log.info("getAll");
        return repository.getAll();
    }
}
