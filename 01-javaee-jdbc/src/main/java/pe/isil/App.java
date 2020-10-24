package pe.isil;

import pe.isil.model.dao.StudentDAO;
import pe.isil.model.Student;

public class App {
    public static void main(String[] args) {
        System.out.println("Hola Mundo!");

        Student student = new Student(1, "Jose", "Ventura", "Arteaga", 30);
        /*student.setId(1);
        student.setFirstName("Jose");
        student.setLastNameFather("Ventura");
        student.setLastNameMother("Arteaga");
        student.setAge(30);*/

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.create(student);
        studentDAO.findAll().forEach(System.out::println);

        student.setAge(20);
        student.setFirstName("Franco");
        studentDAO.update(student);
        studentDAO.findAll().forEach(System.out::println);


        studentDAO.delete(student);
        studentDAO.findAll().forEach(System.out::println);

    }
}
