package com.nighthawk.spring_portfolio.mvc.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface RecipesJpaRepository extends JpaRepository<Recipes, Long> {
    // JPA has many built in methods, these few have been prototyped for this application
    void save(String Recipe);
    List<Recipes> findAllByOrderByRecipeAsc();
    List<Recipes> findByRecipeIgnoreCase(String recipe);
}