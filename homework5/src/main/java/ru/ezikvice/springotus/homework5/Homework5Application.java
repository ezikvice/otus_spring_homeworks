package ru.ezikvice.springotus.homework5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ezikvice.springotus.homework5.dao.BookDao;
import ru.ezikvice.springotus.homework5.domain.Book;

@SpringBootApplication
public class Homework5Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework5Application.class, args);

        ApplicationContext context = SpringApplication.run(Homework5Application.class);
        BookDao dao = context.getBean(BookDao.class);

        dao.insert(new Book(1, "book1", "first book ever"));

        Book b1 = dao.getById(1);
        System.out.println(b1);

    }
}
