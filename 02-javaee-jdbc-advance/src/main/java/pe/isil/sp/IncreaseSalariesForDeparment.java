package pe.isil.sp;

import pe.isil.util.DataBaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IncreaseSalariesForDeparment {
    public static void main(String[] args) {

        try (Connection connection = DataBaseUtil.getConnection()) {

            /**** Department ***
             *HR
             *Engineering
             *Legal
             */
            String theDepartment="Engineering";
            double theIncreaseAmount=1000.0;

            System.out.println("Salaries before");
            showSalaries(connection, theDepartment);

            CallableStatement cs = connection.prepareCall("{call increase_salaries_for_department(?,?)}");

            cs.setString(1, theDepartment);
            cs.setDouble(2, theIncreaseAmount);

            System.out.println("calling sp");
            cs.execute();

            System.out.println("Salaries after");
            showSalaries(connection, theDepartment);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void showSalaries(Connection connection, String theDepartment) {

        final String SQL = "SELECT * FROM employees WHERE department=?";

        try(PreparedStatement ps = connection.prepareStatement(SQL)){

            ps.setString(1, theDepartment);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("%s, %s, %s, %.2f\n", firstName, lastName, department, salary);

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
