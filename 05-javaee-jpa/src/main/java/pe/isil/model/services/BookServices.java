package pe.isil.model.services;

import pe.isil.model.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookServices {

    EntityManager manager;

    public BookServices(EntityManagerFactory emf) {
        this.manager = emf.createEntityManager();
    }

    public void createOrUpdate(Book book) {
        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();
    }

    public void delete(Book book){
        manager.getTransaction().begin();
        manager.remove(book);
        manager.getTransaction().commit();
    }

    public List<Book> findAll(){
        return manager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book findById(Integer id){
        return manager.find(Book.class, id);
    }


}
