package ru.javaprojects.restaurant_vote_system.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javaprojects.restaurant_vote_system.model.Dish;
import ru.javaprojects.restaurant_vote_system.repository.DishRepository;

import java.util.List;

import static ru.javaprojects.restaurant_vote_system.controller.admin.DishRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
public class DishRestController {
    static final String REST_URL = "/rest/admin/dish";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DishRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Dish dish) {
        Dish created = repository.save(dish);
        log.info("create id {}", created.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Dish dish) {
        Dish updated = repository.save(dish);
        log.info("update id {}", updated.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") Integer id) {
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
    public List<Dish> getAll() {
        log.info("getAll");
        return repository.getAll();
    }
}
