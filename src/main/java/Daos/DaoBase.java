package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String user= "root";
        String pass= "root";
        String url = "jdbc:mysql://localhost:3306/bi_corp_business?serverTimezone=America/Lima";

        return DriverManager.getConnection(url,user,pass);
    }
}