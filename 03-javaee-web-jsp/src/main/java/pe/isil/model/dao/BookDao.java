package pe.isil.model.dao;

import pe.isil.model.entities.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    List<Book> findAll();
    void deleteById(String isbn);
    Book findById(String isbn);
}
