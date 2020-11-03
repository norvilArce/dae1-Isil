package pe.isil.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_libros")
@Entity
public class Book {

    @Id
    @Column(length = 10)
    private String isbn;

    @Column(name = "titulo", length = 50)
    private String title;

    @Column(name = "categoria", length = 30)
    private String category;

    public Book() {
    }

    public Book(String isbn, String title, String category) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
