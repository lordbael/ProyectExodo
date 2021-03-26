package modelo;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Juann Inga
 */
public class Admin extends Persona{
    
    private String usuario;
    private String contrasenia;

    public Admin(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Admin() {
    }

    
    public Admin(String usuario, String contrasenia, String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono, Image foto) {
        super(cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono, foto);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
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
    
    
}
