package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Medidores {

    private String codigo;
    private String color;
    private Date añofab;
    private String tipo;
    private int porcentaje;

    public Medidores() {
    }

    public Medidores(String codigo, String color, Date añofab, String tipo, int porcentaje) {
        this.codigo = codigo;
        this.color = color;
        this.añofab = añofab;
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getAñofab() {
        return añofab;
    }

    public void setAñofab(Date añofab) {
        this.añofab = añofab;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
