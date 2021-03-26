package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class Contratos {

    private String codigocontrato;
    private Date fechacontrato;
    private String fkcedulacliente;
    private String nombrecliente;
    private String apellidocliente;
    private String fkcodigomedidor;
    private String tipomedidor;
    private int costomedidor;

    public Contratos() {
    }

    public Contratos(String codigocontrato, Date fechacontrato, String fkcedulacliente, String nombrecliente, String apellidocliente, String fkcodigomedidor, String tipomedidor, int costomedidor) {
        this.codigocontrato = codigocontrato;
        this.fechacontrato = fechacontrato;
        this.fkcedulacliente = fkcedulacliente;
        this.nombrecliente = nombrecliente;
        this.apellidocliente = apellidocliente;
        this.fkcodigomedidor = fkcodigomedidor;
        this.tipomedidor = tipomedidor;
        this.costomedidor = costomedidor;
    }

    public String getCodigocontrato() {
        return codigocontrato;
    }

    public void setCodigocontrato(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public Date getFechacontrato() {
        return fechacontrato;
    }

    public void setFechacontrato(Date fechacontrato) {
        this.fechacontrato = fechacontrato;
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

    public String getFkcodigomedidor() {
        return fkcodigomedidor;
    }

    public void setFkcodigomedidor(String fkcodigomedidor) {
        this.fkcodigomedidor = fkcodigomedidor;
    }

    public String getTipomedidor() {
        return tipomedidor;
    }

    public void setTipomedidor(String tipomedidor) {
        this.tipomedidor = tipomedidor;
    }

    public int getCostomedidor() {
        return costomedidor;
    }

    public void setCostomedidor(int costomedidor) {
        this.costomedidor = costomedidor;
    }
    

}
