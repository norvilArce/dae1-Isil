package pe.isil.application;

import pe.isil.model.entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyProgram {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("isilPU");
        EntityManager manager = emf.createEntityManager();

        Company company = new Company(null, "12345678", "Isil SAC", null);

        manager.getTransaction().begin();
        manager.persist(company);
        manager.getTransaction().commit();
        System.out.println("copmanu inserted: "+company);

        manager.getTransaction().begin();
        company.setTradeName("Instituto San Ignacio de Loyola SAC");
        manager.getTransaction().commit();
        System.out.println("company updated: "+company);

        manager.getTransaction().begin();
        manager.remove(company);
        manager.getTransaction().commit();

        Company currentCompany = manager.find(Company.class, company.getId());
        System.out.println("current company: "+currentCompany);


    }
}
