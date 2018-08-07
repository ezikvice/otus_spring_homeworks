package ru.ezikvice.springotus.homework5.domain;

import java.util.Set;

public class Author {

    private final int id;
    private String name;
    private Set<Book> books;
    private Set<Genre> genres;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBook(Book book) {
        this.books.add(book);
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setGenre(Genre genre){
        this.genres.add(genre);
    }
}
