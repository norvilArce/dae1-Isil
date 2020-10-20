package pe.isil.sp;

import pe.isil.util.DataBaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class GetEmployeesForDepartment {

    public static void main(String[] args) {

        try (Connection connection = DataBaseUtil.getConnection()) {

             /*** Department ***
             *HR
             *Engineering
             *Legal
             */

            String theDepartment = "Legal";

            CallableStatement cs = connection.prepareCall("{call get_employees_for_department(?)}");
            cs.setString(1, theDepartment);

            cs.execute();

            ResultSet rs = cs.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("%s, %s, %s, %.2f\n", firstName, lastName, department, salary);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
