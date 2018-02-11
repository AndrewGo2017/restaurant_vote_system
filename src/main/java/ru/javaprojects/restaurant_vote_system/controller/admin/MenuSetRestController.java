package ru.javaprojects.restaurant_vote_system.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javaprojects.restaurant_vote_system.model.MenuSet;
import ru.javaprojects.restaurant_vote_system.repository.MenuSetRepository;
import ru.javaprojects.restaurant_vote_system.to.MenuSetTo;

import java.util.List;

import static ru.javaprojects.restaurant_vote_system.controller.admin.MenuSetRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
public class MenuSetRestController{
    static final String REST_URL = "/rest/admin/menu_set";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MenuSetRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody MenuSetTo menuSet) {
        MenuSet created = repository.save(menuSet);
        log.info("create id {}", created.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody MenuSetTo menuSet) {
        MenuSet updated = repository.save(menuSet);
        log.info("update id {}", updated.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuSet get(@PathVariable("id") Integer id) {
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
    public List<MenuSet> getAll() {
        log.info("getAll");
        return repository.getAll();
    }
}
