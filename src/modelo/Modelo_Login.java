/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Modelo_Login extends Admin {

    private static ConexionPG con = new ConexionPG();

    public Modelo_Login(String cod_Admin, String usuario, String contrasenia) {
        super(cod_Admin, usuario, contrasenia);
    }

    public Modelo_Login(String cod_admin) {
        super(cod_admin);
    }
    public Modelo_Login( String cedula, String contrasenia) {
        super(cedula,contrasenia);
        
    }

    public Modelo_Login(String cod_Admin, String usuario, String contrasenia, String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono) {
        super(cod_Admin, usuario, contrasenia, cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono);
    }

    public Modelo_Login() {
    }
    public boolean IniciarSesion() {
        boolean comprobar = false;

        try {
            String sql;
            sql = "SELECT cedula, contrasenia\n"
                    + "FROM admin \n"
                    + "where cedula='"+getCedula()+"' and contrasenia='"+getContrasenia()+"';";

            ResultSet rs = con.query(sql);
            while (rs.next()) {
                System.out.println("USUARIO" + getCedula() + "INICIO SESION");
                comprobar = true;
            }

        } catch (Exception e) {
            comprobar = false;
        }
        return comprobar;
    }

    
    
    
//    public boolean IniciarSesion() {
//        boolean comprobar = false;
//
//        try {
//            String sql;
//            sql = "SELECT cedula, contrasenia\n"
//                    + "FROM admin \n"
//                    + "where cedula='0107453631' and contrasenia='1234';";
//
//            ResultSet rs = con.query(sql);
//            while (rs.next()) {
//                System.out.println("USUARIO" + getUsuario() + "INICIO SESION");
//                comprobar = true;
//            }
//
//        } catch (Exception e) {
//            comprobar = false;
//        }
//        return comprobar;
//    }

}
