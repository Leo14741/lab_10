package Daos;

import Beans.Contrato;
import Dtos.cantidadContratosDto;

import java.sql.*;
import java.util.ArrayList;

public class ContratoDaos extends DaoBase{

    public ArrayList<Contrato> listarContratos() {
        ArrayList<Contrato> listaDeContratos = new ArrayList<>();
        //DaoSelecciones daoSelecciones = new DaoSelecciones();
        //DaoArbitros daoArbitros = new DaoArbitros();

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( "SELECT * FROM lab9.partidos;");){

            while (rs.next()) {
                Contrato contrato = new Contrato();

                contrato.setNroDeContrato(rs.getString(1));
                contrato.setIdCliente(rs.getString(2));
                contrato.setDivisa(rs.getString(3));
                contrato.setEstado(rs.getString(4));
                contrato.setMesesEnEseEstado(Integer.parseInt(rs.getString(5)));

                listaDeContratos.add(contrato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeContratos;
    }

    public ArrayList<cantidadContratosDto> mostrarCantidadContratos(){
        ArrayList<cantidadContratosDto> lista = new ArrayList<>();

        String sql= "";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()){
                cantidadContratosDto cant = new cantidadContratosDto();
                cant.setContratosEstado0(Integer.parseInt(rs.getString(1)));
                cant.setContratosEstado1(Integer.parseInt(rs.getString(2)));
                cant.setContratosEstado2(Integer.parseInt(rs.getString(3)));
                lista.add(cant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;

    }

}
