/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Modelo_Login;
import vista.VistaInicio;
import vista.Vista_Iniciar_sesion;

/**
 *
 * @author Juan Inga
 */
public class Control_Login {

    private Modelo_Login modelo;
    private Vista_Iniciar_sesion vista;
    
    public Control_Login(Modelo_Login modelo, Vista_Iniciar_sesion vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void IniciarContro() {
        vista.getBtnIniciar().addActionListener(l -> Ingresar());
    }
    
    private void Ingresar() {
        
        String usuario = vista.getTxtUsuario().getText();
        String contrasenia = vista.getTxtContra().getText();
        
        Modelo_Login ini = new Modelo_Login(usuario, contrasenia);
        
        if (ini.IniciarSesion()) {
            JOptionPane.showMessageDialog(vista, "¡BIENVENIDO!");            
            vista.setVisible(false);
            Date fecha = new Date();
            SimpleDateFormat form = new SimpleDateFormat("dd/mm/yyyy");
            
            VistaInicio ver = new VistaInicio();
            ControlInicio lg = new ControlInicio(ver);
            lg.iniciaControl();
//            ver.getJlnombre().setText(vista.getTxtUsuario().getText());
//            ver.getJlfecha().setText(form.format(fecha));
            ver.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(vista, "Usuario y contraseña no registrados");            
        }
        
    }
    
}
