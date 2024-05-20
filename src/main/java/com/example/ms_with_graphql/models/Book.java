package com.example.ms_with_graphql.models;


import java.util.UUID;

public class Book {


    private UUID id;
    private String name;
    private String publisher;


    public Book() { }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}