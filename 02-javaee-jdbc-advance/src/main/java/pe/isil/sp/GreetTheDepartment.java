package pe.isil.sp;

import pe.isil.util.DataBaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class GreetTheDepartment {
    public static void main(String[] args) {

        try (Connection connection = DataBaseUtil.getConnection()) {

            /*** Department ***
             *HR
             *Engineering
             *Legal
             */

            String theDepartment = "Engineering";

            CallableStatement cs = connection.prepareCall("{call greet_the_department(?)}");

            //set parameters
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(1, theDepartment);

            //call sp
            System.out.println("Calling stored procedure");
            cs.execute();

            //get the value
            String theResult = cs.getString(1);

            System.out.println("The Result = " + theResult);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
