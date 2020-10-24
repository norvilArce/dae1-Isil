package pe.isil.model.dao;

import pe.isil.model.Student;

import java.util.List;

public interface IStudentDAO {

    public void create(Student student);
    public void update(Student student);
    public void delete(Student student);

    public List<Student> findAll();
    public Student findById(Integer id);
}
