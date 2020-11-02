package pe.isil.model.dao.impl;

import pe.isil.db.DbException;
import pe.isil.model.dao.BookDao;
import pe.isil.model.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoJdbc implements BookDao {

    private Connection conn;

    public BookDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Book book) {

        final String SQL = "INSERT INTO libros (isbn, titulo, categoria) VALUE (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitulo());
            ps.setString(3, book.getCategoria());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("Unexpected Error! No rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Book> findAll() {

        final String SQL = "SELECT * FROM libros";
        try (Statement st = conn.createStatement()) {
            try (ResultSet rs = st.executeQuery(SQL)) {
                List<Book> books = new ArrayList<>();
                while (rs.next()) {
                    String isbn = rs.getString("isbn");
                    String titulo = rs.getString("titulo");
                    String categoria = rs.getString("categoria");

                    Book book = new Book(isbn, titulo, categoria);
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(String isbn) {
        final String SQL = "DELETE FROM libros WHERE isbn=?";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, isbn);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Book findById(String isbn) {
        final String SQL = "SELECT * FROM libros WHERE isbn=?";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, isbn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String isbn1 = rs.getString("isbn");
                    String titulo = rs.getString("titulo");
                    String categoria = rs.getString("categoria");

                    Book book = new Book(isbn1, titulo, categoria);
                    return book;
                }
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
