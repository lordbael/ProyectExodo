package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Factura {
    
    private String codigofactura;
    private Date fechafactura;
    
    private String nombrecliente;
    private String fkcedulacliente;
    private String apellidocliente;
    private String direccion;
    private String fkcodigocontrato;
    private double costowatts;
    private int watts;
    private double total;
    
    public Factura(String codigofact) {
        this.codigofactura=codigofact;
    }

    public Factura(String codigofactura, Date fechafactura, String nombrecliente, String fkcedulacliente, String apellidocliente, String direccion, String fkcodigocontrato, double costowatts, int watts, double total) {
        this.codigofactura = codigofactura;
        this.fechafactura = fechafactura;
        this.nombrecliente = nombrecliente;
        this.fkcedulacliente = fkcedulacliente;
        this.apellidocliente = apellidocliente;
        this.direccion = direccion;
        this.fkcodigocontrato = fkcodigocontrato;
        this.costowatts = costowatts;
        this.watts = watts;
        this.total = total;
    }
    public Factura(){
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

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getFkcedulacliente() {
        return fkcedulacliente;
    }

    public void setFkcedulacliente(String fkcedulacliente) {
        this.fkcedulacliente = fkcedulacliente;
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

    public String getFkcodigocontrato() {
        return fkcodigocontrato;
    }

    public void setFkcodigocontrato(String fkcodigocontrato) {
        this.fkcodigocontrato = fkcodigocontrato;
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

    public double getTotal() {
        
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   

    
   
   
    
}
