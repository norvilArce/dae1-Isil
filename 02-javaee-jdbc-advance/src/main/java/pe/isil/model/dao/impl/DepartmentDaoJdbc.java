package pe.isil.model.dao.impl;

import pe.isil.db.DbException;
import pe.isil.model.dao.DepartmentDao;
import pe.isil.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJdbc implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {

        String SQL = "INSERT INTO department (name) VALUES (?)";

        try(PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, department.getName());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    department.setId(id);
                }

            }else {
                throw new DbException("Unexoected error: No rows affected");
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void update(Department department) {

        String SQL = "UPDATE department SET Name = ? WHERE Id = ?";

        try(PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, department.getName());
            ps.setInt(2, department.getId());

            ps.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        String SQL = "DELETE FROM department WHERE Id = ?";

        try(PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);

            ps.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Department findById(Integer id) {
        String SQL = "SELECT * FROM department WHERE Id = ?";

        try(PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){
                    int id1 = rs.getInt("Id");
                    String name = rs.getString("Name");

                    return new Department(id1, name);
                }

                return null;
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Department> findAll() {
        String SQL = "SELECT * FROM department ORDER BY Name";

        try(PreparedStatement ps = conn.prepareStatement(SQL)) {

            try(ResultSet rs = ps.executeQuery()){

                List<Department> list = new ArrayList<>();

                while (rs.next()){
                    int id1 = rs.getInt("Id");
                    String name = rs.getString("Name");

                    Department department = new Department(id1, name);
                    list.add(department);

                }

                return list;
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }
}