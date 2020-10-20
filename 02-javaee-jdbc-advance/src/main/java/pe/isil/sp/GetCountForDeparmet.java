package pe.isil.sp;

import pe.isil.util.DataBaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class GetCountForDeparmet {

    public static void main(String[] args) {

        //get a connection
        try (Connection connection = DataBaseUtil.getConnection()) {

             /*** Department ***
             *HR
             *Engineering
             *Legal
             */

            String theDepartment = "Engineering";

            //prepare the sp call
            CallableStatement cs = connection.prepareCall("{call get_count_for_department(?,?)}");

            //set parameters
            cs.setString(1, theDepartment);
            cs.registerOutParameter(2, Types.INTEGER);

            //call sp
            cs.execute();

            //get the value
            int theCount = cs.getInt(2);
            System.out.println("The count = "+theCount);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
