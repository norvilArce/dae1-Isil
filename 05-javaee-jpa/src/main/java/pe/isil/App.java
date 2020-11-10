package pe.isil;

import pe.isil.model.entities.Book;
import pe.isil.model.services.BookServices;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("isilPU");
        BookServices bookServices = new BookServices(emf);

        Book book = new Book("ISBN1010", "JavaEE in action", "Software Dev");

        bookServices.createOrUpdate(book);

    }
}
