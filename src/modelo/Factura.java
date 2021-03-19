package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga
 */
public class Factura {

    private String codigofac;
    private Date fechafac;
    private String cedulacliente;
    private String nombrecliente;
    private String codigomedidor;
    private String tipomedidor;
    private double consumo;
    private double total;

    public Factura(String codigofac, Date fechafac, String cedulacliente, String nombrecliente, String codigomedidor, String tipomedidor, double consumo, double total) {
        this.codigofac = codigofac;
        this.fechafac = fechafac;
        this.cedulacliente = cedulacliente;
        this.nombrecliente = nombrecliente;
        this.codigomedidor = codigomedidor;
        this.tipomedidor = tipomedidor;
        this.consumo = consumo;
        this.total = total;
    }

    public Factura() {
    }

    public String getCodigofac() {
        return codigofac;
    }

    public void setCodigofac(String codigofac) {
        this.codigofac = codigofac;
    }

    public Date getFechafac() {
        return fechafac;
    }

    public void setFechafac(Date fechafac) {
        this.fechafac = fechafac;
    }

    public String getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(String cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getCodigomedidor() {
        return codigomedidor;
    }

    public void setCodigomedidor(String codigomedidor) {
        this.codigomedidor = codigomedidor;
    }

    public String getTipomedidor() {
        return tipomedidor;
    }

    public void setTipomedidor(String tipomedidor) {
        this.tipomedidor = tipomedidor;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
