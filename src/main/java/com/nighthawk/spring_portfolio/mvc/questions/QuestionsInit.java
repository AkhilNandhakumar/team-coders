// package com.nighthawk.spring_portfolio.mvc.questions;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Component;

// @Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
// public class QuestionsInit {
    
//     // Inject repositories
//     @Autowired QuestionsJpaRepository repository;
    
//     @Bean
//     CommandLineRunner run() {  // The run() method will be executed after the application starts
//         return args -> {
//             // Fail safe data validations

//             // starting jokes
//             final String[] questionsArray = {
//                 "temp",
//             };

//             // make sure Joke database is populated with starting jokes
//             for (String question : questionsArray) {
//                 List<Questions> test = repository.findByQuestionIgnoreCase(question);  // JPA lookup
               
//                 if (test.size() == 0)
//                     repository.save(new Questions(null, question)); //JPA save
//                     // repository.deleteAll();
//             }
            
//         };
//     }
// }
