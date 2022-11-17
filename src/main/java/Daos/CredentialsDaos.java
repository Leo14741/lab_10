package Daos;

import Beans.Credentials;
import java.sql.*;
import java.util.ArrayList;

public class CredentialsDaos extends DaoBase{

    public Credentials validarUsuarioPassword(String username, String password) {

        Credentials credentials = null;

        String sql = "SELECT * FROM employees_credentials WHERE email = ? AND password = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()){
                    int employeeId = rs.getInt(1);
                    credentials = this.obtenerEmpleado(employeeId);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return credentials;
    }


}
