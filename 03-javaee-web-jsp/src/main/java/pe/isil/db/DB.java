package pe.isil.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            try {

                Properties props = loadProperties();
                String url = props.getProperty("dburl");

                conn = DriverManager.getConnection(url, props);

            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties() {

        try (FileInputStream fs = new FileInputStream("D:/ISIL/DESARROLLO DE SOFTWARE/3er ciclo/Desarrollo de Aplicaciones Empresariales I/clases/db.properties")) {

            Properties props = new Properties();
            props.load(fs);
            return props;

        } catch (FileNotFoundException e) {
            throw new DbException(e.getMessage());
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
