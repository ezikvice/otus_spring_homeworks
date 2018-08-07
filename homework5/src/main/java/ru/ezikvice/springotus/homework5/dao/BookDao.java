package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);

    Book getById(int id);
}
