/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloAdmin;
import vista.VistaAdmin;

/**
 *
 * @author Juann Inga
 */
public class ControlAdmin {
    
    private ModeloAdmin modelo;
    private VistaAdmin vista;

    public ControlAdmin(ModeloAdmin modelo, VistaAdmin vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    
    
}
