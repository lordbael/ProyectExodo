package main;

import controlador.ControlInicio;
import controlador.ControlCliente;
import modelo.ModeloCliente;
import vista.VistaInicio;
import vista.VistaClientes;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ProyectoExodo {

    public static void main(String[] args) {
        
       VistaInicio vistainicio = new VistaInicio();
       ControlInicio ci = new ControlInicio(vistainicio);
       ci.iniciaControl();

    }

}
