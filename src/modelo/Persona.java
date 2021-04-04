package modelo;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private String genero;
    private Date fechanac;
    private String direccion;
    private String correo;
    private String telefono;
    private Image foto;

    public Persona() {
    }

    public Persona(String cedula) {
        this.cedula = cedula;
    }
 
    public Persona(String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechanac = fechanac;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }


}
