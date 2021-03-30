/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
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
public class ModeloPersona extends Persona {

    private static ConexionPG conectar = new ConexionPG();

    public ModeloPersona() {
    }

    public ModeloPersona(String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono, Image foto) {
        super(cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono, foto);
    }

    public static List<Persona> ListarPersonas() {

        {

            try {
                String query = "SELECT * FROM persona";
                ResultSet rs = conectar.query(query);
                List<Persona> lista = new ArrayList<Persona>();
                while (rs.next()) {

                    Persona persona = new Persona();
                    persona.setCedula(rs.getString("cedula"));
                    persona.setNombre(rs.getString("nombre"));
                    persona.setApellido(rs.getString("apellido"));
                    persona.setGenero(rs.getString("genero"));
                    persona.setFechanac(rs.getDate("fechanacimiento"));
                    persona.setDireccion(rs.getString("direccion"));
                    persona.setCorreo(rs.getString("correo"));
                    persona.setTelefono(rs.getString("telefono"));
                    lista.add(persona);

                }
                rs.close();
                return lista;
            } catch (SQLException ex) {
                Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }
    }
}
