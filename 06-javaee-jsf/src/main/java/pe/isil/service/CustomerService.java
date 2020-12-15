package pe.isil.service;

import pe.isil.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerService {

    @PersistenceContext
    private EntityManager manager;

    public void create(Customer customer){
        manager.persist(customer);
    }
    public void update(Customer customer){
        manager.merge(customer);
    }

    public List<Customer> getAll(){
        return manager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }


}
