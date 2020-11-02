package pe.isil.model.dao;

import pe.isil.model.entities.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    void update(Book book);
    void deleteById(String isbn);

    Book findById(String isbn);
    List<Book> findAll();
}
