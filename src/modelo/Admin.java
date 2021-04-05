package modelo;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Juann Inga
 */
public class Admin extends Persona{
    private String cod_Admin;
    private String usuario;
    private String contrasenia;

    public Admin(String cod_Admin, String usuario, String contrasenia) {
        this.cod_Admin = cod_Admin;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public Admin(String cod_admin) {
        this.cod_Admin=cod_admin;    
    }
    
    public Admin(String cod_Admin, String usuario, String contrasenia, String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono) {
        super(cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono);
        this.cod_Admin = cod_Admin;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    public Admin(){
        
    }
    public Admin(String cedula,String contrasenia){
        cedula=getCedula();
        this.contrasenia=contrasenia;
        
    }

    public String getCod_Admin() {
        return cod_Admin;
    }

    public void setCod_Admin(String cod_Admin) {
        this.cod_Admin = cod_Admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Admin{" + "cod_Admin=" + cod_Admin + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }

    
    
    

   
    
}
