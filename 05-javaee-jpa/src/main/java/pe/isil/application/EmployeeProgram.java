package pe.isil.application;

import pe.isil.model.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class EmployeeProgram {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("isilPU");
        EntityManager manager = emf.createEntityManager();

        Company company = new Company(null, "12345678", "Isil SAC", null);

        manager.getTransaction().begin();
        manager.persist(company);
        manager.getTransaction().commit();
        System.out.println("company inserted: " + company);

        Address address1 = new Address(null, "Av. Benavides 1180", "Lima", "Peru", null);
        Address address2 = new Address(null, "Av. Arequipa 5034", "Lima", "Peru", null);

        Employee jose = new Employee(null, "11111111", "Jose", "Ventura", "Arteaga", LocalDate.of(1990, 3, 31), company, address1);
        Employee juan = new Employee(null, "22222222", "Juan", "Perez", "Del Olmo", LocalDate.of(1980, 4, 21), company, address2);

        manager.getTransaction().begin();
        manager.persist(jose);
        manager.persist(juan);
        manager.getTransaction().commit();

        System.out.println("employee Jose inserted " + jose);
        System.out.println("employee Juan inserted " + juan);

        List<Employee> employeeList = manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        employeeList.forEach(System.out::println);

        Project project1 = new Project(null, "project Boom!", 10000.0, 1000, true, null);
        manager.getTransaction().begin();
        manager.persist(project1);
        manager.getTransaction().commit();
        System.out.println("project inserted: " + project1);

        EmployeeProjectKey key = new EmployeeProjectKey();
        key.setEmployeeId(jose.getId());
        key.setProjectId(project1.getId());

        EmployeeProject employeeProject1 = new EmployeeProject();
        employeeProject1.setId(key);
        employeeProject1.setEmployee(jose);
        employeeProject1.setProject(project1);
        employeeProject1.setCreatedDate(LocalDate.now());

        manager.getTransaction().begin();
        manager.persist(employeeProject1);
        manager.getTransaction().commit();
        System.out.println("employeeProject1 inserted: " + employeeProject1);

        EmployeeProjectKey key2 = new EmployeeProjectKey();
        key2.setEmployeeId(juan.getId());
        key2.setProjectId(project1.getId());

        EmployeeProject employeeProject2 = new EmployeeProject();
        employeeProject2.setId(key2);
        employeeProject2.setEmployee(juan);
        employeeProject2.setProject(project1);
        employeeProject2.setCreatedDate(LocalDate.now());

        manager.getTransaction().begin();
        manager.persist(employeeProject2);
        manager.getTransaction().commit();
        System.out.println("employeeProject1 inserted: " + employeeProject1);

    }
}
