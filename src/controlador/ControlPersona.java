/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloPersona;
import modelo.Persona;
import vista.VistaPersonas;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlPersona {
    
    private ModeloPersona modelo;
    private VistaPersonas vista;

    public ControlPersona(ModeloPersona modelo, VistaPersonas vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void iniciarControl(){
        vista.getBtnActualizar().addActionListener(l->cargaLista());
        
    }
    
    private void cargaLista() {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPersonas().getModel();
        tblModel.setNumRows(0);
        List<Persona> lista = ModeloPersona.ListarPersonas();
        lista.stream().forEach(p1 -> {
            String[] persona = {p1.getCedula(), p1.getNombre(), p1.getApellido(),p1.getGenero(), String.valueOf(p1.getFechanac()),p1.getDireccion(),p1.getCorreo(),p1.getTelefono()};
            tblModel.addRow(persona);
        });
    }
    
    

}
