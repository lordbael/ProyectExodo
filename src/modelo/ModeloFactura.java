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
public class ModeloFactura extends Factura {

    private static ConexionPG con = new ConexionPG();

    public ModeloFactura(String codigofactura, Date fechafactura, String nombrecliente, String fkcedulacliente, String apellidocliente, String direccion, String fkcodigocontrato, double costowatts, int watts, double total) {
        super(codigofactura, fechafactura, nombrecliente, fkcedulacliente, apellidocliente, direccion, fkcodigocontrato, costowatts, watts, total);
    }

    public ModeloFactura(String codigoFact) {
        super(codigoFact);
    }

    public ModeloFactura() {
    }

    public boolean crear() {

        String sql;
        sql = "INSERT INTO factura(\n"
                + "            codigofactura, fechafactura, nombrecliente, fkcedulacliente, \n"
                + "            apellidocliente, direccion, fkcodigocontrato, costowatts, watts, \n"
                + "            total)\n"
                + "    VALUES ('" + getCodigofactura() + "', '" + getFechafactura() + "', '" + getNombrecliente() + "', \n"
                + "            '" + getFkcedulacliente() + "', '" + getApellidocliente() + "', '" + getDireccion() + "', '" + getFkcodigocontrato() + "','" + getCostowatts() + "', \n"
                + "            '" + getWatts() + "','" + getTotal() + "');";

        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    ;
   
    
    
    public boolean modificar() {
        String sql;
        sql = "UPDATE factura\n"
                + "   SET fechafactura='" + getFechafactura() + "', nombrecliente='" + getNombrecliente() + "', fkcedulacliente='" + getFkcedulacliente() + "', \n"
                + "       apellidocliente='" + getApellidocliente() + "', direccion='" + getDireccion() + "', fkcodigocontrato='" + getFkcodigocontrato() + "', costowatts='" + getCostowatts() + "', \n"
                + "       watts=?, total=?\n"
                + " WHERE codigofactura='" + getCodigofactura() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {

            return false;
        }
    }

    public static List<Factura> listar(String aguja) {

        try {
            String query = "SELECT codigofactura, fechafactura, nombrecliente, fkcedulacliente, \n"
                    + "       apellidocliente, direccion, fkcodigocontrato, costowatts, watts, \n"
                    + "       total\n"
                    + "  FROM factura WHERE;";

            query += "upper(codigofactura) LIKE upper('%" + aguja + "%') OR ";
            query += "upper(fechafactura) LIKE upper('%" + aguja + "%') OR ";
            query += "upper(fkcedulacliente) LIKE upper('%" + aguja + "%')";

            ResultSet rs = con.query(query);
            List<Factura> lista = new ArrayList<Factura>();
            //byte[] bf;
            while (rs.next()) {

                Factura fac1 = new Factura();
                fac1.setCodigofactura(rs.getString("codigofactura"));
                fac1.setFechafactura(rs.getDate("fechafactura"));
                fac1.setNombrecliente(rs.getString("nombrecliente"));
                fac1.setFkcedulacliente(rs.getString("fkcedulacliente"));
                fac1.setApellidocliente(rs.getString("apellidocliente"));
                fac1.setDireccion(rs.getString("direccion"));
                fac1.setFkcodigocontrato(rs.getString("fkcodigocontrato"));
                fac1.setCostowatts(rs.getDouble("costowatts"));
                fac1.setWatts(rs.getInt("watts"));
                fac1.setTotal(rs.getDouble("total"));
                lista.add(fac1);

            }

            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    ;
    
    public List<Factura> buscar() {
        try {
            String query = "select * from factura where codigofactura='" + getCodigofactura() + "';";
            ResultSet rs = con.query(query);
            List<Factura> lista = new ArrayList<Factura>();
            //byte[] bf;
            while (rs.next()) {
                Factura fac1 = new Factura();
                fac1.setCodigofactura(rs.getString("codigofactura"));
                fac1.setFechafactura(rs.getDate("fechafactura"));
                fac1.setNombrecliente(rs.getString("nombrecliente"));
                fac1.setFkcedulacliente(rs.getString("fkcedulacliente"));
                fac1.setApellidocliente(rs.getString("apellidocliente"));
                fac1.setDireccion(rs.getString("direccion"));
                fac1.setFkcodigocontrato(rs.getString("fkcodigocontrato"));
                fac1.setCostowatts(rs.getDouble("costowatts"));
                fac1.setWatts(rs.getInt("watts"));
                fac1.setTotal(rs.getDouble("total"));
                lista.add(fac1);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean Eliminar() {

        String sql;
        sql = "DELETE FROM factura\n"
                + " WHERE codigofactura='" + getCodigofactura() + "';";

        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
;

}
