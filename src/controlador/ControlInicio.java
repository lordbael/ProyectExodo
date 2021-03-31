/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloAdmin;
import modelo.ModeloContrato;
import modelo.ModeloFactura;
import modelo.ModeloMedidor;
import modelo.ModeloPersona;
import vista.VistaAdmin;
import vista.VistaContratos;
import vista.VistaFacturas;
import vista.VistaInicio;
import vista.VistaMedidores;
import vista.VistaPersonas;

/**
 *
 * @author Juann Inga
 */
public class ControlInicio {
    VistaInicio vi;

    public ControlInicio(VistaInicio vi) {
        this.vi = vi;
        vi.setVisible(true);
    }
    
    public void iniciaControl(){
        
        vi.getTblCrudPersonas().addActionListener(l-> crudPersonas());
        vi.getTblCrudMedidores().addActionListener(l-> crudMedidores());
        vi.getTblCrudContratos().addActionListener(l-> crudContratos());
        vi.getTblCrudFacturas().addActionListener(l-> crudFacturas());
        vi.getTblCrudAdmin().addActionListener(l-> crudAdmin());
        
    }
    
    public void crudPersonas(){
        
        ModeloPersona m = new ModeloPersona();
        VistaPersonas v = new VistaPersonas();
        ControlPersona c = new ControlPersona(m, v);
        vi.getDesktop().add(v);
        c.iniciarControl();
        
    }
    
    public void crudMedidores(){
        ModeloMedidor m = new ModeloMedidor();
        VistaMedidores v = new VistaMedidores();
        ControlMedidor c = new ControlMedidor(m,v);
        vi.getDesktop().add(v);
        
    }
    
    public void crudContratos(){
        ModeloContrato m = new ModeloContrato();
        VistaContratos v = new VistaContratos();
        ControlContrato c = new ControlContrato(m,v);
        vi.getDesktop().add(v);
        
    }
    public void crudFacturas(){
        ModeloFactura m = new ModeloFactura();
        VistaFacturas v = new VistaFacturas();
        ControlFactura c = new ControlFactura(m,v);
        vi.getDesktop().add(v);
        
    }
    
    public void crudAdmin(){
        ModeloAdmin m = new ModeloAdmin();
        VistaAdmin v = new VistaAdmin();
        ControlAdmin c = new ControlAdmin(m,v);
        vi.getDesktop().add(v);
        
        
    }
    
    
}
