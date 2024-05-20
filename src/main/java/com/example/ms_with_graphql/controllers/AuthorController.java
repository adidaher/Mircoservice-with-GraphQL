package com.example.ms_with_graphql.controllers;

import com.example.ms_with_graphql.models.Author;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthorController {

    private List<Author> authors = new ArrayList<>() {{
        add(new Author(UUID.randomUUID(), "adi"));
        add(new Author(UUID.randomUUID(), "sami"));
        add(new Author(UUID.randomUUID(), "amir"));
    }};

    @QueryMapping
    List<Author> authors(){
        return  authors;
    }

    @QueryMapping
    Author authorByName(@Argument String name){
        return authors.stream()
                .filter(author -> author.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null); // Return null if no author is found
    }

    @MutationMapping
    Author addAuthor(@Argument String name){
        Author newAuthor = new Author(UUID.randomUUID(), name);
        authors.add(newAuthor);
        return  newAuthor;
    }

}
