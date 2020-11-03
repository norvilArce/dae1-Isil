package pe.isil.application;

import pe.isil.model.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BookProgram {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("isilPU");
        EntityManager manager = emf.createEntityManager();

        Book book = new Book();
        book.setIsbn("ISBN000001");
        book.setTitle("Harry Potter ye l prisonero de Azkaban");
        book.setCategory("Magia");

        //(1) Create
        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();

        book.setTitle("Harry y la piedra");
        book.setCategory("Comedia");

        //(2) Update
        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();

        //(3) List
        List<Book> books = manager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        for (Book b:
                books
             ) {
            System.out.println(b);
        }

        //(4) findById
        Book currentBook = manager.find(Book.class, "ISBN000001");
        System.out.println(currentBook);

        //(5) Delete
        manager.getTransaction().begin();
        manager.remove(book);
        manager.getTransaction().commit();

    }
}
