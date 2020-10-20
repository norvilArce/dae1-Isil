package pe.isil.model.dao.impl;

import pe.isil.db.DbException;
import pe.isil.model.dao.SellerDao;
import pe.isil.model.entities.Department;
import pe.isil.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoJdbc implements SellerDao {

    private Connection conn;

    public SellerDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller seller) {

        String SQL = "INSERT INTO department (name) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, seller.getName());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    seller.setId(id);
                }

            } else {
                throw new DbException("Unexoected error: No rows affected");
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Seller seller) {
        final String SQL = "UPDATE seller SET Name=?, Email=?, BirthDate=?, BaseSalary=?, DepartmentId=? WHERE Id=?";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, seller.getName());
            ps.setString(2, seller.getEmail());
            ps.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            ps.setDouble(4, seller.getBaseSalary());
            ps.setInt(5, seller.getDepartment().getId());
            ps.setInt(6, seller.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        final String SQL = "DELETE FROM seller WHERE Id=?";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Seller findById(Integer id) {
        final String SQL = "SELECT seller.*, d.Name as DepName FROM seller " +
                " INNER JOIN department d on seller.DepartmentId = d.Id" +
                " WHERE seller.Id = ?";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Department department = instantiateDepartment(rs);
                    return instantiateSeller(rs, department);
                }
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }


    @Override
    public List<Seller> findAll() {

        final String SQL = "SELECT s.*, d.Name as DepName " +
                " FROM seller s" +
                " INNER JOIN department d on s.DepartmentId = d.Id" +
                " ORDER BY s.Name";

        try (Statement st = conn.createStatement()) {
            try (ResultSet rs = st.executeQuery(SQL)) {

                List<Seller> sellerList = new ArrayList<>();

                while (rs.next()) {
                    Department department = instantiateDepartment(rs);
                    Seller seller = instantiateSeller(rs, department);
                    sellerList.add(seller);
                }

                return sellerList;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {

        final String SQL = "SELECT s.*, d.Name as DepName " +
                " FROM seller s" +
                " INNER JOIN department d on s.DepartmentId = d.Id" +
                " WHERE s.DepartmentId = ?" +
                " ORDER BY s.Name";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, department.getId());

            try (ResultSet rs = ps.executeQuery()) {

                List<Seller> sellerList = new ArrayList<>();

                while (rs.next()) {
                    Department currentDepartment = instantiateDepartment(rs);
                    Seller seller = instantiateSeller(rs, currentDepartment);
                    sellerList.add(seller);
                }

                return sellerList;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }


    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
        int id1 = rs.getInt("Id");
        String name = rs.getString("Name");
        String email = rs.getString("Email");
        java.util.Date birthDate = rs.getDate("BirthDate");
        double baseSalary = rs.getDouble("BaseSalary");

        Seller seller = new Seller(id1, name, email, birthDate, baseSalary, department);
        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        int departmentId = rs.getInt("DepartmentId");
        String depName = rs.getString("DepName");

        Department department = new Department(departmentId, depName);
        return department;
    }

}