package Daos;

import Beans.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDaos extends DaoBase{

        public ArrayList<Cliente> listarClientes(){
            ArrayList<Cliente> lista = new ArrayList<>();

            try (Connection conn = this.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery( "SELECT g4093_name, g4093_age,g4093_type,g4093_documentType,g4093_nro_id,\n" +
                         "\t   case when g4093_type = \"J\" then \"Juridica\"\n" +
                         "\t\t\twhen g4093_type = \"N\" then \"Normal\"\n" +
                         "            end as tipoCliente\n" +
                         " FROM bi_corp_business.jm_client_bii;");){

                while (rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setNombreCliente(rs.getString("g4093_name"));
                    cliente.setEdad(rs.getString("g4093_age"));
                    cliente.setTipoCliente(rs.getString("tipoCliente"));
                    cliente.setTipoDocumento(rs.getString("g4093_documentType"));
                    cliente.setNumeroDocumento(rs.getString("g4093_nro_id"));
                    lista.add(cliente);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return lista;
        }

    public Cliente buscarCliente(String nroId) {

        Cliente cliente = new Cliente();

        String sql = "SELECT g4093_name, g4093_age,g4093_type,g4093_documentType,g4093_nro_id,\n" +
                "\t   case when g4093_type = \"J\" then \"Juridica\"\n" +
                "\t\t\twhen g4093_type = \"N\" then \"Normal\"\n" +
                "            end as tipoCliente\n" +
                " FROM bi_corp_business.jm_client_bii;";

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, nroId);
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()) {
                    cliente.setNombreCliente(rs.getString("g4093_name"));
                    cliente.setEdad(rs.getString("g4093_age"));
                    cliente.setTipoCliente(rs.getString("tipoCliente"));
                    cliente.setTipoDocumento(rs.getString("g4093_documentType"));
                    cliente.setNumeroDocumento(rs.getString("g4093_nro_id"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void crearCredentialCliente(Cliente cliente){


        String sql = "INSERT INTO jm_client_bii(g4093_name, g4093_age, g4093_type, g4093_documentType, g4093_nro_id) VALUES (?,?,?,?,sha2(?,256),?,?,?,?,?)";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombreCliente());
            pstmt.setString(2, cliente.getEdad());
            pstmt.setString(3, cliente.getTipoCliente());
            pstmt.setString(4, cliente.getTipoDocumento());
            pstmt.setString(5, cliente.getNumeroDocumento());

            pstmt.executeUpdate();
            //pstmt.setBytes(12, usuario.getFotoPerfil().getFotobyte());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

