package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Medidores {

    private String codigomedidor;
    private String marca;
    private String tipo;
    private Date aniofabricacion;
    private String capacidad;
    private int precio;

    public Medidores() {
    }

    public Medidores(String codigomedidor, String marca, String tipo, Date aniofabricacion, String capacidad, int precio) {
        this.codigomedidor = codigomedidor;
        this.marca = marca;
        this.tipo = tipo;
        this.aniofabricacion = aniofabricacion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public String getCodigomedidor() {
        return codigomedidor;
    }

    public void setCodigomedidor(String codigomedidor) {
        this.codigomedidor = codigomedidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getAñofab() {
        return aniofabricacion;
    }

    public void setAñofab(Date aniofabricacion) {
        this.aniofabricacion = aniofabricacion;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

   
}
