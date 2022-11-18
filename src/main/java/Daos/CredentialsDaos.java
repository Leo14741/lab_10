package Daos;

import Beans.Cliente;
import Beans.Credentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CredentialsDaos extends DaoBase{

    public Credentials validarUsuarioPassword(String username, String password) {

        String sql = "SELECT * FROM credentials WHERE nro_documento = ? AND password = ?";
        Credentials credentials = new Credentials();
        ClienteDaos clienteDaos = new ClienteDaos();

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()){
                    credentials.setNumeroDocumento(rs.getString(1));
                    credentials.setTipoUsuario(Integer.parseInt(rs.getString("TipoUsuario")));
                }else {
                    credentials = null;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return credentials;
    }

}
