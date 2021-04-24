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
import modelo.ModeloCliente;
import vista.VistaAdmin;
import vista.VistaContratos;
import vista.VistaFacturas;
import vista.VistaInicio;
import vista.VistaMedidores;
import vista.VistaClientes;

/**
 *
 * @author Juann Inga
 */
public class ControlInicio {

    VistaInicio vi;

    public ControlInicio(VistaInicio vi) {
        this.vi = vi;
        vi.setVisible(true);
        vi.setTitle("Exodo");
    }

    public void iniciaControl() {

        vi.getTblCrudPersonas().addActionListener(l -> crudPersonas());
        vi.getTblCrudMedidores().addActionListener(l -> crudMedidores());
        vi.getTblCrudContratos().addActionListener(l -> crudContratos());
        vi.getTblCrudFacturas().addActionListener(l -> crudFacturas());
        vi.getTblCrudAdmin().addActionListener(l -> crudAdmin());

    }

    public void crudPersonas() {

        ModeloCliente m = new ModeloCliente();
        VistaClientes v = new VistaClientes();
        vi.getDesktop().add(v);
        ControlCliente c = new ControlCliente(m, v);
        c.iniciaControl();

    }

    public void crudMedidores() {
        ModeloMedidor m = new ModeloMedidor();
        VistaMedidores v = new VistaMedidores();
        vi.getDesktop().add(v);
        ControlMedidor c = new ControlMedidor(m, v);
        c.iniciaControl();

    }

    public void crudContratos() {
        ModeloContrato m = new ModeloContrato();
        VistaContratos v = new VistaContratos();
        vi.getDesktop().add(v);
        ControlContrato c = new ControlContrato(m, v);
        c.iniciaControl();

    }

    public void crudFacturas() {
        ModeloFactura m = new ModeloFactura();
        VistaFacturas v = new VistaFacturas();
        vi.getDesktop().add(v);
        ControlFactura c = new ControlFactura(m, v);
        c.iniciaControl();

    }

    public void crudAdmin() {
        ModeloAdmin m = new ModeloAdmin();
        VistaAdmin v = new VistaAdmin();
        vi.getDesktop().add(v);
        ControlAdmin c = new ControlAdmin(m, v);
        c.iniciaControl();
    }

}
