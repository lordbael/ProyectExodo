package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Factura {
    
    private String codigofactura;
    private Date fechafactura;
    private String fkcodigocontrato;
    private String fkcedulacliente;
    private String nombrecliente;
    private String apellidocliente;
    private String direccion;
    private String fkcodigomedidor;
    private double costowatts;
    private int watts;

    public Factura() {
    }

    public Factura(String codigofactura, Date fechafactura, String fkcodigocontrato, String fkcedulacliente, String nombrecliente, String apellidocliente, String direccion, String fkcodigomedidor, double costowatts, int watts) {
        this.codigofactura = codigofactura;
        this.fechafactura = fechafactura;
        this.fkcodigocontrato = fkcodigocontrato;
        this.fkcedulacliente = fkcedulacliente;
        this.nombrecliente = nombrecliente;
        this.apellidocliente = apellidocliente;
        this.direccion = direccion;
        this.fkcodigomedidor = fkcodigomedidor;
        this.costowatts = costowatts;
        this.watts = watts;
    }

    public String getCodigofactura() {
        return codigofactura;
    }

    public void setCodigofactura(String codigofactura) {
        this.codigofactura = codigofactura;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getFkcodigocontrato() {
        return fkcodigocontrato;
    }

    public void setFkcodigocontrato(String fkcodigocontrato) {
        this.fkcodigocontrato = fkcodigocontrato;
    }

    public String getFkcedulacliente() {
        return fkcedulacliente;
    }

    public void setFkcedulacliente(String fkcedulacliente) {
        this.fkcedulacliente = fkcedulacliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getApellidocliente() {
        return apellidocliente;
    }

    public void setApellidocliente(String apellidocliente) {
        this.apellidocliente = apellidocliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFkcodigomedidor() {
        return fkcodigomedidor;
    }

    public void setFkcodigomedidor(String fkcodigomedidor) {
        this.fkcodigomedidor = fkcodigomedidor;
    }

    public double getCostowatts() {
        return costowatts;
    }

    public void setCostowatts(double costowatts) {
        this.costowatts = costowatts;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

   
    
}
