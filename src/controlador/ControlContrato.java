/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloContrato;
import vista.VistaContratos;

/**
 *
 * @author Juann Inga
 */
public class ControlContrato {

    private ModeloContrato modelo;
    private VistaContratos vista;

    public ControlContrato(ModeloContrato modelo, VistaContratos vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

   

}
