package main;

import controlador.ControlInicio;
import controlador.ControlPersona;
import modelo.ModeloPersona;
import vista.VistaInicio;
import vista.VistaPersonas;

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
