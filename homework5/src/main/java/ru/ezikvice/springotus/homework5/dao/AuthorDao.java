package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

public interface AuthorDao {

    void insert(Author author);

    Author getById(int id);

    List<Author> getByGenre(Genre genre);

    List<Author> getByBook(Book book);
}
