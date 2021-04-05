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
public class ModeloMedidor extends Medidores {

    private static ConexionPG conectar = new ConexionPG();

    public ModeloMedidor(String codigomedidor) {
        super(codigomedidor);
    }

    public ModeloMedidor() {
    }

    public ModeloMedidor(String codigomedidor, String marca, String tipo, Date aniofabricacion, String capacidad, int precio) {
        super(codigomedidor, marca, tipo, aniofabricacion, capacidad, precio);
    }


    public boolean grabarMedidor() {
        String sql;
        sql = "INSERT INTO medidor(codigomedidor,marca,tipo,aniofabricacion,capacidad,precio)";
        sql += "VALUES('" + getCodigomedidor() + "','" + getMarca() + "','" + getTipo() + "','" + getAniofabricacion()+ "','" + getCapacidad() + "','" + getPrecio() + "')";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public static List<Medidores> ListarMedidores(String aguja) {
        try {
            String query = "SELECT * FROM medidor WHERE ";

            query += "UPPER(codigomedidor) LIKE UPPER('%" + aguja + "%') OR ";
            query += "UPPER(marca) LIKE UPPER('%" + aguja + "%') ";
       

            ResultSet rs = conectar.query(query);

            List<Medidores> lista = new ArrayList<Medidores>();
            while (rs.next()) {

                Medidores medidores = new Medidores();
                medidores.setCodigomedidor(rs.getString("codigomedidor"));
                medidores.setMarca(rs.getString("marca"));
                medidores.setTipo(rs.getString("tipo"));
                medidores.setAniofabricacion(rs.getDate("aniofabricacion"));
                medidores.setCapacidad(rs.getString("capacidad"));
                medidores.setPrecio(rs.getInt("precio"));
                 lista.add(medidores);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMedidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     public List<Medidores> buscarMedidor() {
        try {
            String query = "select * from medidor where codigomedidor='" + getCodigomedidor()+ "';";
            ResultSet rs = conectar.query(query);
            List<Medidores> lista = new ArrayList<Medidores>();
    
            while (rs.next()) {
                Medidores medidores = new Medidores();
                medidores.setCodigomedidor(rs.getString("codigomedidor"));
                medidores.setMarca(rs.getString("marca"));
                medidores.setTipo(rs.getString("tipo"));
                medidores.setAniofabricacion(rs.getDate("aniofabricacion"));
                medidores.setCapacidad(rs.getString("capacidad"));
                medidores.setPrecio(rs.getInt("precio"));
                
                lista.add(medidores);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMedidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
      public boolean EditarMedidor() {
        String sql;
        sql = "UPDATE medidor SET marca='" + getMarca()+ "', tipo='" + getTipo()+ "',"
                + "aniofabricacion='" + getAniofabricacion()+ "', capacidad='" + getCapacidad()+ "',"
                + "precio='" + getPrecio()+ "' "
                + "WHERE codigomedidor='" + getCodigomedidor()+ "';";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            return false;
        }
    }
       public boolean EliminarMedidor() {

        String sql;
        sql = "DELETE FROM medidor WHERE codigomedidor='" + getCodigomedidor() + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
      

     

    

}
