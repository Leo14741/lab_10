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
             ResultSet rs = stmt.executeQuery( "SELECT * FROM bi_corp_business.jm_cotr_bis;");){

            while (rs.next()) {
                Contrato contrato = new Contrato();
                int estado= rs.getInt("G6789_status");
                switch (estado){
                    case 0:
                        contrato.setEstado("Normal");
                    case 1:
                        contrato.setEstado("Cura");
                    case 2:
                        contrato.setEstado("Mora");
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
