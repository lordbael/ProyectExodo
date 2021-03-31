/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloFactura;
import vista.VistaFacturas;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlFactura {
    
    private ModeloFactura modelo;
    private VistaFacturas vista;

    public ControlFactura(ModeloFactura modelo, VistaFacturas vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    
    
}
