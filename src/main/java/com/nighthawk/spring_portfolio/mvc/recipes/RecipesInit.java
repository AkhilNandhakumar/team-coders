package com.nighthawk.spring_portfolio.mvc.recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class RecipesInit {
    
    // Inject repositories
    @Autowired RecipesJpaRepository repository;
    
    @Bean
    CommandLineRunner run() {  // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // starting jokes
            final String[] recipesArray = {
                "Classic Shrimp Scampi: https://www.foodnetwork.com/recipes/food-network-kitchen/classic-shrimp-scampi-8849846",
                "Ground Turkey Enchilada Stir-Fry: https://www.foodnetwork.com/recipes/ground-turkey-enchilada-stir-fry-with-couscous-3416321",
                "Tricolore Stuffed Pork: https://www.foodnetwork.com/recipes/giada-de-laurentiis/tricolore-stuffed-pork-3549235",
                "Chamomile French Toast: https://www.foodnetwork.com/recipes/geoffrey-zakarian/chamomile-french-toast-3715601",
                "Cuban Picadillo: https://www.foodnetwork.com/recipes/ingrid-hoffmann/cuban-picadillo-recipe-2047190",
                "Mocha Mousse Pie: https://www.foodnetwork.com/recipes/food-network-kitchen/mocha-mousse-pie-3562562",
                "Pumpkin Crumble: https://www.foodnetwork.com/recipes/food-network-kitchen/pumpkin-crumble-3561621",
                "Parker House Rolls: https://www.foodnetwork.com/recipes/food-network-kitchen/parker-house-rolls-with-sea-salt-recipe-2043484",
                "Curried Chicken Thighs: https://www.foodnetwork.com/recipes/curried-chicken-thighs-recipe-1957943",
                "Chocolate Mousse: https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-chocolate-mousse-8612586",
                "Pumpkin Bread Pudding: https://www.foodnetwork.com/recipes/bobby-flay/pumpkin-bread-pudding-with-spicy-caramel-apple-sauce-and-vanilla-bean-creme-anglaise-recipe-1922571",
            };

            // make sure Joke database is populated with starting jokes
            for (String recipe : recipesArray) {
                List<Recipes> test = repository.findByRecipeIgnoreCase(recipe);  // JPA lookup
                if (test.size() == 0)
                    repository.save(new Recipes(null, recipe, 0, 0)); //JPA save
            }
            
        };
    }
}
