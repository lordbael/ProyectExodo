package main;

import controlador.ControlPersona;
import modelo.ModeloPersona;
import vista.VistaPersonas;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ProyectoExodo {

    public static void main(String[] args) {
        
        ModeloPersona m = new ModeloPersona();
        VistaPersonas v = new VistaPersonas();
        ControlPersona c = new ControlPersona(m, v);
        c.iniciarControl();
        

    }

}
