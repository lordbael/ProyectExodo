/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juann Inga
 */
public class ModeloContrato extends Contratos {

    private static ConexionPG conectar = new ConexionPG();

    public ModeloContrato(String codigocontrato) {
        super(codigocontrato);
    }

    public ModeloContrato() {
    }

    public ModeloContrato(String codigocontrato, Date fechacontrato, String fkcedulacliente, String fkcodigomedidor) {
        super(codigocontrato, fechacontrato, fkcedulacliente, fkcodigomedidor);
    }

    public boolean grabarContrato() {
        String sql;
        sql = "INSERT INTO contrato( codigocontrato,  fechacontrato,  fkcedulacliente,  fkcodigomedidor)";
        sql += "VALUES('" + getCodigocontrato() + "','" + getFechacontrato() + "','" + getFkcedulacliente() + "','" + getFkcodigomedidor() + "')";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public static List<Contratos> ListarContratos(String aguja) {
        try {
            String query = "SELECT * FROM contrato WHERE ";

            query += "UPPER(codigocontrato) LIKE UPPER('%" + aguja + "%')  ";
            query += "ORDER BY (codigocontrato)";

            ResultSet rs = conectar.query(query);

            List<Contratos> lista = new ArrayList<Contratos>();
            while (rs.next()) {

                Contratos contratos = new Contratos();
                contratos.setCodigocontrato(rs.getString("codigocontrato"));
                contratos.setFechacontrato(rs.getDate("fechacontrato"));
                contratos.setFkcedulacliente(rs.getString("fkcedulacliente"));
                contratos.setFkcodigomedidor(rs.getString("fkcodigomedidor"));
                lista.add(contratos);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMedidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<Contratos> buscarContratos() {
        try {
            String query = "select * from contrato where codigocontrato='" + getCodigocontrato() + "';";
            ResultSet rs = conectar.query(query);
            List<Contratos> lista = new ArrayList<Contratos>();

            while (rs.next()) {
                Contratos contratos = new Contratos();
                contratos.setCodigocontrato(rs.getString("codigocontrato"));
                contratos.setFechacontrato(rs.getDate("fechacontrato"));
                contratos.setFkcedulacliente(rs.getString("fkcedulacliente"));
                contratos.setFkcodigomedidor(rs.getString("fkcodigomedidor"));
                lista.add(contratos);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloContrato.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean EditarContrato() {
        String sql;
        sql = "UPDATE contrato SET fechacontrato='" + getFechacontrato() + "', fkcedulacliente='" + getFkcedulacliente() + "',"
                + "fkcodigomedidor='" + getFkcodigomedidor() + "'"
                + "WHERE codigocontrato='" + getCodigocontrato() + "';";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            return false;
        }
    }

    public boolean EliminarContrato() {

        String sql;
        sql = "DELETE FROM contrato WHERE codigocontrato='" + getCodigocontrato() + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidarCed(String cedula) {
        try {
            boolean verificacion = false;

            String sql;
            sql = "SELECT fkcodigomedidor "
                    + "from contrato where fkcodigomedidor = '" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                verificacion = true;

            }
            rs.close();
            return verificacion;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloContrato.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }

    }
;

}
