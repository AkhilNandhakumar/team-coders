package com.nighthawk.spring_portfolio.mvc.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/recipes")  // all requests in file begin with this URI
public class RecipesApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private RecipesJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Recipes>> getRecipes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PutMapping("/like/{id}")
    public ResponseEntity<Recipes> setLike(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Recipes> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Recipes recipe = optional.get();  // value from findByID
            recipe.setHaha(recipe.getHaha()+1); // increment value
            repository.save(recipe);  // save entity
            return new ResponseEntity<>(recipe, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update Jeer
     */
    @PutMapping("/jeer/{id}")
    public ResponseEntity<Recipes> setJeer(@PathVariable long id) {
        Optional<Recipes> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Recipes recipe = optional.get();
            recipe.setBoohoo(recipe.getBoohoo()+1);
            repository.save(recipe);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}