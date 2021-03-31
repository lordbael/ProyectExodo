/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloMedidor;
import vista.VistaMedidores;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlMedidor {

    private ModeloMedidor modelo;
    private VistaMedidores vista;

    public ControlMedidor(ModeloMedidor modelo, VistaMedidores vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

}
