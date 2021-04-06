/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Admin;
import modelo.ModeloAdmin;
import vista.VistaAdmin;

/**
 *
 * @author Juann Inga
 */
public class ControlAdmin {

    private ModeloAdmin modelo;
    private VistaAdmin vista;
    String st;
    boolean validarBotonA;

    public ControlAdmin(ModeloAdmin modelo, VistaAdmin vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControl() {
        KeyListener kn1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cargarLista(vista.getTxtBuscar().getText());
            }
        };

        vista.getBtnActualizarEx().addActionListener(l -> cargarLista(""));

        vista.getBtnNuevoEx().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialog();
        });
        vista.getBtnAceptarAd().addActionListener(l -> validarBoton());

        vista.getBtnEditarEx().addActionListener((ActionEvent l) -> {
            editar();
            this.validarBotonA = false;
        });

        vista.getBtnEliminarEx().addActionListener(l -> Delet());
        vista.getBtnCancelarAd().addActionListener(l -> cerrarVentana());
        vista.getTxtBuscar().addKeyListener(kn1);
        vista.getBtnExaminarAd().addActionListener(l -> cargarInmagen());
        //vista.getBtnimprimir().addActionListener(l -> ImprimirReporte());

    }

    private void validarBoton() {
        if (validarBotonA) {
            grabarPersona();
        } else {
            EditarPersona();
        }
    }

    private void cargarLista(String aguja) {

        vista.getTblAdmin().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblAdmin().setRowHeight(100);
        DefaultTableCellRenderer renderer = new sun.swing.table.DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblAdmin().getModel();
        tblModel.setNumRows(0);
        List<Admin> lista = ModeloAdmin.listar(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {

            tblModel.addRow(new Object[ncols]);
            vista.getTblAdmin().setValueAt(p1.getCod_Admin(), i.value, 0);
            vista.getTblAdmin().setValueAt(p1.getCedula(), i.value, 1);
            vista.getTblAdmin().setValueAt(p1.getNombre(), i.value, 2);
            vista.getTblAdmin().setValueAt(p1.getApellido(), i.value, 3);
            vista.getTblAdmin().setValueAt(p1.getGenero(), i.value, 4);
            vista.getTblAdmin().setValueAt(p1.getFechanac(), i.value, 5);
            vista.getTblAdmin().setValueAt(p1.getDireccion(), i.value, 6);
            vista.getTblAdmin().setValueAt(p1.getCorreo(), i.value, 7);
            vista.getTblAdmin().setValueAt(p1.getTelefono(), i.value, 8);

            Image img = p1.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblAdmin().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblAdmin().setValueAt(null, i.value, 9);
            }
            i.value++;
            ;
            //vista.getTblAdmin().setValueAt(p1.getUsuario(), i.value, 10);

            //vista.getTblAdmin().setValueAt(p1.getContrasenia(), i.value, 11);
        });
    }

    private void grabarPersona() {
        if (Validacion()) {

            String cod_administrador = vista.getTxtCodigoAd().getText();
            String cedula = vista.getTxtCedulaAd().getText();
            String nombre = vista.getTxtNombreAd().getText();
            String apellido = vista.getTxtApellidoAd().getText();
            String sexo = "";
            sexo = vista.getCmbGeneroAd().getSelectedItem().toString();
            String direccion = vista.getTxtDireccionAd().getText();
            Instant instante = vista.getDtcFechaAd().getDate().toInstant();
            ZoneId zi = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
            Date fechaNacimiento = Date.valueOf(zdt.toLocalDate());
            String correo = vista.getTxtCorreoAd().getText();
            String telefono = vista.getTxtTelefonoAd().getText();
            String tipo_us = "";
            tipo_us = vista.getCmbTipoUsuarioAd().getSelectedItem().toString();
            String contrasenia = vista.getTxtContraseniaAd().getText();

            ModeloAdmin persona = new ModeloAdmin(cod_administrador, cedula, nombre, apellido, sexo, fechaNacimiento, direccion, correo, telefono, tipo_us, contrasenia);

            ImageIcon ic = (ImageIcon) vista.getLblFotoAd().getIcon();
            persona.setFoto(ic.getImage());

            if (persona.crear()) {
                cargarLista("");
                vista.getDlgAdmin().setVisible(false);
                JOptionPane.showMessageDialog(vista, "Admin Creada Existosamente");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR!!!!!!");
            }
        }
    }

    public boolean Validacion() {
        boolean verificar = true;
        //////////////////////////////codigo admincliente
        if (vista.getTxtCodigoAd().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en código administador excedido", "Código cliente errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCodigoAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de código administrador es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        //////////////////////////////cedula
        if (vista.getTxtCedulaAd().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en cédula excedido", "Cédula errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCedulaAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de cédula es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        ///////////////////////////////////////////////////////////////////nombres
        if (vista.getTxtNombreAd().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en nombre excedido", "Nombre erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtNombreAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de nombre es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////apellidos
        if (vista.getTxtApellidoAd().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en apellido excedido", "Apellido erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtApellidoAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de apellido es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////fecha
//        if (vista.getDtcFecha().getDate().toString().equals("Seleccione")) {
//            JOptionPane.showMessageDialog(null, "El campo de fecha es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
//            verificar = false;
//        }

        ////////////////////////////////////////////////////////////////////direccion
        if (vista.getTxtDireccionAd().getText().length() > 100) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en dirección excedido", "Dirección erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtDireccionAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de dirección es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////correo
        if (vista.getTxtCorreoAd().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en correo excedido", "Correo erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCorreoAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de correo es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////telefono
        if (vista.getTxtTelefonoAd().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en teléfono excedido", "Teléfon Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtTelefonoAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de teléfono es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////genero
        if (vista.getCmbGeneroAd().getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "El campo de género es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////tipo de usuario
        if (vista.getCmbTipoUsuarioAd().getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "El campo de tipo de usuario es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////contraseña
        if (vista.getTxtContraseniaAd().getText().length() > 30) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en contraseña excedido", "Contraseña errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtContraseniaAd().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de contraseña es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////foto
//         if (vista.getLblFoto().getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "El campo de foto es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
//            verificar = false;
//        }
        return verificar;

    }

    public void EditarPersona() {

        if (Validacion()) {

            String cod_administrador = vista.getTxtCodigoAd().getText();
            String cedula = vista.getTxtCedulaAd().getText();
            String nombre = vista.getTxtNombreAd().getText();
            String apellido = vista.getTxtApellidoAd().getText();
            String sexo = "";
            sexo = vista.getCmbGeneroAd().getSelectedItem().toString();
            String direccion = vista.getTxtDireccionAd().getText();

            Instant instante = vista.getDtcFechaAd().getDate().toInstant();
            ZoneId zi = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
            Date fechaNacimiento = Date.valueOf(zdt.toLocalDate());

            String correo = vista.getTxtCorreoAd().getText();
            String telefono = vista.getTxtTelefonoAd().getText();

            String tipo_us = "";
            tipo_us = vista.getCmbGeneroAd().getSelectedItem().toString();
            String contrasenia = vista.getTxtContraseniaAd().getText();

            ModeloAdmin persona = new ModeloAdmin(cod_administrador, cedula, nombre, apellido, sexo, fechaNacimiento, direccion, correo, telefono, tipo_us, contrasenia);

            ImageIcon ic = (ImageIcon) vista.getLblFotoAd().getIcon();
            persona.setFoto(ic.getImage());

            if (persona.modificar()) {
                JOptionPane.showMessageDialog(vista, "Admin Modificado Existosamente");
                cargarLista("");
                vista.getDlgAdmin().setVisible(false);

            } else {
                JOptionPane.showMessageDialog(vista, "ERROR!!!!!!");
            }
        }
    }

    public void Delet() {
        try {
            int fila = vista.getTblAdmin().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblAdmin().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea elimianr el Admin\n"
                    + "codigo: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Apellido: " + model.getValueAt(fila, 3).toString() + "\n"
            );
            if (op == 0) {
                ModeloAdmin p1 = new ModeloAdmin();
                p1.setCod_Admin(model.getValueAt(fila, 0).toString());
                if (p1.Eliminar()) {
                    JOptionPane.showMessageDialog(vista, "PERSONA ELIMINADA");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
        }

    }

    private void MuestraDialog() {

        vista.getTxtCodigoAd().setEditable(true);
        vista.getDlgAdmin().setVisible(true);
        vista.getDlgAdmin().setSize(660, 600);
        vista.getDlgAdmin().setTitle("NUEVO ADMIN");
        vista.getDlgAdmin().setLocationRelativeTo(vista);
        vista.getTxtCodigoAd().setText("");
        vista.getTxtNombreAd().setText("");
        vista.getTxtApellidoAd().setText("");
        vista.getDtcFechaAd().setDate(null);
        vista.getTxtTelefonoAd().setText("");
        vista.getTxtContraseniaAd().setText("");
        vista.getCmbGeneroAd().setSelectedItem(0);
        vista.getCmbTipoUsuarioAd().setSelectedItem(0);
        vista.getTxtCorreoAd().setText("");
        vista.getLblFotoAd().setIcon(null);
    }

    private void cargarInmagen() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblFotoAd().getWidth(),
                        vista.getLblFotoAd().getHeight(),
                        Image.SCALE_DEFAULT
                );
                vista.getLblFotoAd().setIcon(new ImageIcon(icono));
                vista.getLblFotoAd().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

//    private void ImprimirReporte() {
//        ConexionPG con = new ConexionPG();
//        double sueldo=100.0;
//        try {
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/rpt_Persona.jasper"));
//            //JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
//            String aguja= vista.getTxtbuscar().getText();
//            Map<String,Object> parametros= new HashMap<String, Object>();
//            parametros.put("aguja","%"+aguja+"%");
//            parametros.put("sueldo",sueldo);
//            
//            JasperPrint jp = JasperFillManager.fillReport(jr,parametros, con.getCon());
//            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
//
//        } catch (JRException ex) {
//            Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    //// metodos para cambiar imagenes
    MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vista.getTblAdmin().rowAtPoint(e.getPoint());
            st = vista.getTblAdmin().getValueAt(index, 0) + "";

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public String Elegir() {
        String idSeleccion = "";
        int fila = vista.getTblAdmin().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblAdmin();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void editar() {
        String seleccionarId = Elegir();
        ModeloAdmin persona = new ModeloAdmin(seleccionarId);
        List<Admin> ps = persona.buscar();
        for (int i = 0; i < ps.size(); i++) {
            Admin indexpersona = ps.get(i);
            String cod_Admin = indexpersona.getCod_Admin();
            String cedula = indexpersona.getCedula();
            String nombre = indexpersona.getNombre();
            String apellido = indexpersona.getApellido();
            Date fecha = (Date) indexpersona.getFechanac();
            String telefono = indexpersona.getTelefono();
            String genero = indexpersona.getGenero();
            String usuario = indexpersona.getUsuario();
            String direccion = indexpersona.getDireccion();
            String correo = indexpersona.getCorreo();
            String contrasenia = indexpersona.getContrasenia();

            MuestraDialog();

            Image img = indexpersona.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vista.getLblFotoAd().setIcon(icon);
            } else {
                vista.getLblFotoAd().setIcon(null);
            }
            vista.getDlgAdmin().setSize(660, 600);
            vista.getDlgAdmin().setTitle("EDITAR PERSONA");
            vista.getDlgAdmin().setLocationRelativeTo(vista);
            vista.getTxtCodigoAd().setText(cod_Admin);
            vista.getTxtCedulaAd().setText(cedula);
            vista.getTxtNombreAd().setText(nombre);
            vista.getTxtApellidoAd().setText(apellido);
            vista.getDtcFechaAd().setDate(fecha);
            vista.getTxtTelefonoAd().setText(telefono);
            vista.getTxtContraseniaAd().setText(contrasenia);
            vista.getCmbGeneroAd().setSelectedItem(genero);
            vista.getCmbTipoUsuarioAd().setSelectedItem(usuario);
            vista.getTxtCorreoAd().setText(correo);
            vista.getTxtDireccionAd().setText(direccion);

        }
    }
    private void cerrarVentana() {
        vista.getDlgAdmin().setVisible(false);

    }

}
