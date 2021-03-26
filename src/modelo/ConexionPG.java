package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ConexionPG {
    
    private Connection conexion;
    private String cadConexion = "jdbc:postgresql://localhost:5432/exodo";
    private String usuario = "postgres";
    private String pass = "1234";
    
    public ConexionPG() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion = DriverManager.getConnection(cadConexion, usuario, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ResultSet query(String sql) {
        try {
            Statement st;

            st = conexion.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public SQLException noQuery(String nsql) {

        try {
            Statement st;
            st = conexion.createStatement();
            st.execute(nsql);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }

    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    
}
