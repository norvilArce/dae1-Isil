package pe.isil.dao;

import pe.isil.model.Student;
import pe.isil.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    @Override
    public void create(Student student) {

        try (Connection connection = DataBaseUtil.getConnection()) {

            final String SQL = "INSERT INTO tbl_students (firstName, lastNameFather, lastNameMother, age) VALUES (?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastNameFather());
                ps.setString(3, student.getLastNameMother());
                ps.setInt(4, student.getAge());

                ps.executeUpdate();

                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        int id = keys.getInt(1);
                        student.setId(id);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void update(Student student) {

        try (Connection connection = DataBaseUtil.getConnection()) {

            final String SQL = "UPDATE tbl_students SET firtsName=?, lastNameFather=?, lastNameMother=?, age=? WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastNameFather());
                ps.setString(3, student.getLastNameMother());
                ps.setInt(4, student.getAge());
                ps.setInt(5, student.getId());

                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(Student student) {

        try (Connection connection = DataBaseUtil.getConnection()) {

            final String SQL = "DELETE FROM tbl_students WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setInt(1, student.getId());
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }


    @Override
    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection()) {

            final String SQL = "SELECT * FROM tbl_students";

            try (Statement stm = connection.createStatement()) {
                try (ResultSet rs = stm.executeQuery(SQL)) {
                    while (rs.next()) {
                        int id = rs.getInt("id");//numeor o nombre de la columna
                        String firstName = rs.getString("firstName");
                        String lastNameFather = rs.getString("lastNameFather");
                        String lastNameMother = rs.getString("lastNameMother");
                        int age = rs.getInt("Age");

                        Student student = new Student(id, firstName, lastNameFather, lastNameMother, age);
                        students.add(student);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return students;
    }

    @Override
    public Student findById(Integer id) {

        Student student = null;

        try (Connection connection = DataBaseUtil.getConnection()) {

            final String SQL = "SELECT * FROM tbl_students WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {

                        int idStudent = rs.getInt("id");//numeor o nombre de la columna
                        String firstName = rs.getString("firstName");
                        String lastNameFather = rs.getString("lastNameFather");
                        String lastNameMother = rs.getString("lastNameMother");
                        int age = rs.getInt("Age");

                        student = new Student(idStudent, firstName, lastNameFather, lastNameMother, age);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return student;
    }
}
