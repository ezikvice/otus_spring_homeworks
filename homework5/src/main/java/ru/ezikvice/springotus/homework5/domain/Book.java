package ru.ezikvice.springotus.homework5.domain;

import java.util.Set;

public class Book {

    private final int id;
    private String name;
    private String description;
    private Set<Author> authors;

    public Book(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

}
