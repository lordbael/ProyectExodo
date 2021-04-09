package main;

import controlador.ControlCliente;
import controlador.Control_Login;
import modelo.ModeloCliente;
import modelo.Modelo_Login;
import vista.VistaInicio;
import vista.VistaClientes;
import vista.Vista_Iniciar_sesion;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ProyectoExodo {

    public static void main(String[] args) {
        
       Vista_Iniciar_sesion vistas =  new Vista_Iniciar_sesion();
       vistas.setTitle("Exodo v1.0");
       vistas.setLocationRelativeTo(null);
       Modelo_Login lg = new Modelo_Login();
       Control_Login ci = new Control_Login(lg,vistas);
       ci.IniciarContro();

    }

}
