package Daos;

import Beans.Contrato;
import Dtos.cantidadContratosDto;

import java.sql.*;
import java.util.ArrayList;

public class ContratoDaos extends DaoBase{

    public ArrayList<Contrato> listarContratos() {
        ArrayList<Contrato> listaDeContratos = new ArrayList<>();
        //DaoSelecciones daoSelecciones = new DaoSelecciones();
        //DaoArbitros daoArbitros = new DaoArbitros();1

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( "SELECT * FROM bi_corp_business.jm_cotr_bis");){

            while (rs.next()) {
                Contrato contrato = new Contrato();
                int estado= rs.getInt("G6789_status");
                switch (estado){
                    case 0:
                        contrato.setEstado("Normal");
                        break;
                    case 1:
                        contrato.setEstado("Cura");
                        break;
                    case 2:
                        contrato.setEstado("Mora");
                        break;
                }

                contrato.setNroDeContrato(rs.getString(1));
                contrato.setIdCliente(rs.getString(2));
                contrato.setDivisa(rs.getString(3));
                contrato.setMesesEnEseEstado(Integer.parseInt(rs.getString(5)));

                listaDeContratos.add(contrato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeContratos;
    }

    public cantidadContratosDto mostrarCantidadContratos(){
        cantidadContratosDto cantidadContratosDto = new cantidadContratosDto();

        String sql= "SELECT * FROM bi_corp_business.jm_cotr_bis WHERE client_nro_id = ?";
        // falta mandar el id del cliente

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int contratosEstado0=0;
            int contratosEstado1=0;
            int contratosEstado2=0;

            while(rs.next()){
                if (rs.getString("G6789_status").equals("0")){
                    contratosEstado0++;
                } else if (rs.getString("G6789_status").equals("1")) {
                    contratosEstado1++;
                } else if (rs.getString("G6789_status").equals("2")) {
                    contratosEstado2++;
                }
            }

            cantidadContratosDto.setContratosEstado0(contratosEstado0);
            cantidadContratosDto.setContratosEstado1(contratosEstado1);
            cantidadContratosDto.setContratosEstado2(contratosEstado2);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cantidadContratosDto;

    }

}
