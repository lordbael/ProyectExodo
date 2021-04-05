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

    private String fkcodigomedidor;
    
    public Contratos(){
        
    }

    public Contratos(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }
    

    public Contratos(String codigocontrato, Date fechacontrato, String fkcedulacliente, String fkcodigomedidor) {
        this.codigocontrato = codigocontrato;
        this.fechacontrato = fechacontrato;
        this.fkcedulacliente = fkcedulacliente;
        this.fkcodigomedidor = fkcodigomedidor;
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

    public String getFkcodigomedidor() {
        return fkcodigomedidor;
    }

    public void setFkcodigomedidor(String fkcodigomedidor) {
        this.fkcodigomedidor = fkcodigomedidor;
    }
    

}
