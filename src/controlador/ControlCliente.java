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
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Clientes;
import modelo.ConexionPG;
import modelo.ModeloCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VistaClientes;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlCliente {

    private ModeloCliente modelo;
    private VistaClientes vista;
    boolean validarBotonA;

    public ControlCliente(ModeloCliente modelo, VistaClientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControl() {
        KeyListener kl = new KeyListener() {
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

        //Eventos Vista Principal
        vista.getBtnActualizar().addActionListener(l -> cargarLista(""));

        vista.getBtnNuevo().addActionListener(l -> {
            this.validarBotonA = true;
            muestraDialogo();
        });
        vista.getBtnAceptar().addActionListener(l -> validarBoton());

        vista.getBtnEditar().addActionListener((ActionEvent l) -> {
            editarCliente();
            this.validarBotonA = false;
        });

        vista.getBtnEliminar().addActionListener(l -> Delet());
        vista.getBtnCancelar().addActionListener(l -> cerrarVentana());
        vista.getTxtBuscar().addKeyListener(kl);
        vista.getBtnExaminar().addActionListener(l -> cargarImagen());
        vista.getBtnImprimir().addActionListener(l -> ImprimeReporte());

    }

    private void validarBoton() {
        if (validarBotonA) {
            grabarClientes();
        } else {
            grabarEditarClientes();
        }
    }

    private void cargarLista(String aguja) {

        vista.getTblClientes().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblClientes().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
        tblModel.setNumRows(0);
        List<Clientes> lista = ModeloCliente.ListarClientes(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pl -> {
            //String[] persona = {pl.getIdPersona(), pl.getNombre(), pl.getApellido(), String.valueOf(pl.getEdad()), pl.getTelefono(), pl.getSexo(), String.valueOf(pl.getSueldo()), String.valueOf(pl.getCupo())};
            tblModel.addRow(new Object[ncols]);
            vista.getTblClientes().setValueAt(pl.getCedula(), i.value, 0);
            vista.getTblClientes().setValueAt(pl.getCodigo_cliente(), i.value, 1);
            vista.getTblClientes().setValueAt(pl.getNombre(), i.value, 2);
            vista.getTblClientes().setValueAt(pl.getApellido(), i.value, 3);
            vista.getTblClientes().setValueAt(pl.getGenero(), i.value, 4);
            vista.getTblClientes().setValueAt(pl.getFechanac(), i.value, 5);
            vista.getTblClientes().setValueAt(pl.getDireccion(), i.value, 6);
            vista.getTblClientes().setValueAt(pl.getCorreo(), i.value, 7);
            vista.getTblClientes().setValueAt(pl.getTelefono(), i.value, 8);
            vista.getTblClientes().setValueAt(pl.getFoto(), i.value, 9);
            Image img = pl.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblClientes().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblClientes().setValueAt(null, i.value, 9);
            }
            i.value++;
            ;
        });
    }

    //mostrar el diálogo al presionar el boton NUEVO
    private void muestraDialogo() {
        vista.getTxtCodigoCliente().setEditable(true);
        vista.getDlgClientes().setVisible(true);
        vista.getDlgClientes().setSize(650, 425);
        vista.getDlgClientes().setTitle("NUEVO CLIENTE");
        vista.getDlgClientes().setLocationRelativeTo(vista);
        vista.getTxtCodigoCliente().setText("");
        vista.getTxtCedula().setEditable(true);
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getCmbGenero().setSelectedItem(0);
        vista.getDtcFecha().setDate(null);
        vista.getTxtDireccion().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtTelefono().setText("");
        vista.getLblFoto().setIcon(null);
    }

    private void grabarClientes() {
        if (Validacion()) {

            String codigo_cliente = vista.getTxtCodigoCliente().getText();
            String cedula = vista.getTxtCedula().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String sexo = "";
            sexo = vista.getCmbGenero().getSelectedItem().toString();
            Instant instant = vista.getDtcFecha().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
            String direccion = vista.getTxtDireccion().getText();
            String correo = vista.getTxtCorreo().getText();
            String telefono = vista.getTxtTelefono().getText();

            ModeloCliente cliente = new ModeloCliente(codigo_cliente, cedula, nombre, apellido, sexo, fechanacimiento, direccion, correo, telefono);

            ImageIcon ic = (ImageIcon) vista.getLblFoto().getIcon();
            cliente.setFoto(ic.getImage());

            if (cliente.grabar()) {
                cargarLista("");
                vista.getDlgClientes().setVisible(false);
                JOptionPane.showMessageDialog(vista, "Registro creado satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(vista, "El cliente ya se encuentra registrado");
            }
        }

    }

    public boolean Validacion() {
        boolean verificar = true;
        //////////////////////////////cedula
        if (vista.getTxtCedula().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en CÉDULA excedido", "Cédula errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCedula().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de CÉDULA es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        //////////////////////////////codigo cliente
        if (vista.getTxtCodigoCliente().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en CÓDIGO CLIENTE excedido", "Código cliente errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCodigoCliente().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de CÓDIGO CLIENTE es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////////////nombres
        if (vista.getTxtNombre().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en NOMBRE excedido", "Nombre erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtNombre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de NOMBRE es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////apellidos
        if (vista.getTxtApellido().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en APELLIDO excedido", "Apellido erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtApellido().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de APELLIDO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////genero
        if (vista.getCmbGenero().getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "El campo de GÉNERO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////fecha
//        if (vista.getDtcFecha().getDate().toString().equals("Seleccione")) {
//            JOptionPane.showMessageDialog(null, "El campo de fecha es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
//            verificar = false;
//        }

        ////////////////////////////////////////////////////////////////////direccion
        if (vista.getTxtDireccion().getText().length() > 100) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en DIRECCIÓN excedido", "Dirección erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtDireccion().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de DIRECCIÓN es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////correo
        if (vista.getTxtCorreo().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en CORREO excedido", "Correo erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCorreo().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de CORREO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////telefono
        if (vista.getTxtTelefono().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en TELÉFONO excedido", "Teléfono Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtTelefono().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de TELÉFONO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////foto
//         if (vista.getLblFoto().getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "El campo de foto es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
//            verificar = false;
//        }
        return verificar;

    }

    private void cargarImagen() {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblFoto().getWidth(),
                        vista.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                vista.getLblFoto().setIcon(ic);
                vista.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String Elegir() {
        String idSeleccion = "";
        int fila = vista.getTblClientes().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblClientes();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void editarCliente() {
        String seleccionarId = Elegir();
        ModeloCliente cliente = new ModeloCliente(seleccionarId);
        List<Clientes> ps = cliente.buscarEditar();
        for (int i = 0; i < ps.size(); i++) {
            Clientes indexcliente = ps.get(i);
            String codigo_cliente = indexcliente.getCodigo_cliente();
            String cedula = indexcliente.getCedula();
            String nombre = indexcliente.getNombre();
            String apellido = indexcliente.getApellido();
            String genero = indexcliente.getGenero();
            Date fecha = (Date) indexcliente.getFechanac();
            String direccion = indexcliente.getDireccion();
            String correo = indexcliente.getCorreo();
            String telefono = indexcliente.getTelefono();

            muestraDialogo();

            Image img = indexcliente.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vista.getLblFoto().setIcon(icon);
            } else {
                vista.getLblFoto().setIcon(null);
            }
            vista.getDlgClientes().setTitle("EDITAR CLIENTE");

            vista.getTxtCodigoCliente().setText(codigo_cliente);
            vista.getTxtCodigoCliente().setEditable(false);
            vista.getTxtCedula().setEditable(false);
            vista.getTxtCedula().setText(cedula);
            vista.getTxtNombre().setText(nombre);
            vista.getTxtApellido().setText(apellido);
            vista.getCmbGenero().setSelectedItem(genero);
            vista.getDtcFecha().setDate(fecha);
            vista.getTxtDireccion().setText(direccion);
            vista.getTxtCorreo().setText(correo);
            vista.getTxtTelefono().setText(telefono);
        }
    }

    private void grabarEditarClientes() {
        if (Validacion()) {
            String codigo_cliente = vista.getTxtCodigoCliente().getText();
            String cedula = vista.getTxtCedula().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String sexo = "";
            sexo = vista.getCmbGenero().getSelectedItem().toString();

            Instant instant = vista.getDtcFecha().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());

            String direccion = vista.getTxtDireccion().getText();
            String correo = vista.getTxtCorreo().getText();
            String telefono = vista.getTxtTelefono().getText();

            ModeloCliente cliente = new ModeloCliente(codigo_cliente, cedula, nombre, apellido, sexo, fechanacimiento, direccion, correo, telefono);

            ImageIcon ic = (ImageIcon) vista.getLblFoto().getIcon();
            cliente.setFoto(ic.getImage());
            if (cliente.Editar()) {
                JOptionPane.showMessageDialog(vista, "El registro se ha editado satisfactoriamente");
                cargarLista("");
                vista.getDlgClientes().setVisible(false);

            } else {
                JOptionPane.showMessageDialog(vista, "ERROR");
            }
        }

    }

    private void cerrarVentana() {
        vista.getDlgClientes().setVisible(false);

    }

    public void Delet() {
        try {
            int fila = vista.getTblClientes().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblClientes().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\t¿Desea eliminar el cliente seleccionado?\n"
                    + "Cédula: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Código Cliente: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Apellido: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                ModeloCliente c1 = new ModeloCliente();
                c1.setCedula(model.getValueAt(fila, 0).toString());
                if (c1.Eliminar()) {
                    JOptionPane.showMessageDialog(vista, "El cliente ha sido eliminado");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminar");
        }

    }

    private void ImprimeReporte() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/rptCliente.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
