/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Clientes;
import modelo.Contratos;
import modelo.Medidores;
import modelo.ModeloCliente;
import modelo.ModeloContrato;
import modelo.ModeloMedidor;
import vista.VistaContratos;

/**
 *
 * @author Juann Inga
 */
public class ControlContrato {

    private ModeloContrato modelo;
    private VistaContratos vista;
    String st;
    boolean validarBotonA;

    public ControlContrato(ModeloContrato modelo, VistaContratos vista) {
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
                cargarListaCli(vista.getTxtBuscarCliente().getText());
                cargarListaMed(vista.getTxtBuscarMedidor().getText());
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
            editarContrato();
            this.validarBotonA = false;
        });

        vista.getBtnEliminar().addActionListener(l -> Delet());
        vista.getBtnCancelar().addActionListener(l -> cerrarVentana());
        vista.getTxtBuscar().addKeyListener(kl);
        vista.getTxtBuscarCliente().addKeyListener(kl);
        vista.getBtnBuscarDlg().addActionListener(l -> llenarCliente());
        vista.getTxtBuscarMedidor().addKeyListener(kl);
        vista.getBtnBuscarDlgMedidor().addActionListener(l -> llenarMedidores());
        //--------------------------------------------------------------
        vista.getBtnCliente().addActionListener(l -> ObtenerClientes());
        vista.getBtnMedidor().addActionListener(l -> MuestraMedidor());

    }

    private void validarBoton() {
        if (validarBotonA) {
            grabarContrato();
        } else {
            grabarEditarContratos();
        }
    }

    private void cargarLista(String aguja) {
        vista.getTblContratos().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblContratos().setRowHeight(30);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblContratos().getModel();
        tblModel.setNumRows(0);
        List<Contratos> lista = ModeloContrato.ListarContratos(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pl -> {

            tblModel.addRow(new Object[ncols]);
            vista.getTblContratos().setValueAt(pl.getCodigocontrato(), i.value, 0);
            vista.getTblContratos().setValueAt(pl.getFechacontrato(), i.value, 1);
            vista.getTblContratos().setValueAt(pl.getFkcedulacliente(), i.value, 2);
            vista.getTblContratos().setValueAt(pl.getFkcodigomedidor(), i.value, 3);

            i.value++;

        });
    }

    private void cargaListas(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblContratos().getModel();
        tblModel.setNumRows(0);
        List<Contratos> lista = ModeloContrato.ListarContratos(aguja);
        lista.stream().forEach(p1 -> {
            String[] contrato = {p1.getCodigocontrato()};

            tblModel.addRow(contrato);
        });
    }

    private void muestraDialogo() {
        vista.getTxtCodigoContrato().setEditable(true);
        vista.getDlgContratos().setVisible(true);
        vista.getDlgContratos().setSize(630, 320);
        vista.getDlgContratos().setTitle("NUEVO CONTRATO");
        vista.getDlgContratos().setLocationRelativeTo(vista);
        vista.getTxtCodigoContrato().setText("");
        vista.getDtcFecha().setDate(null);
        vista.getTxtCedula().setText("");
        vista.getTxtCodigoMedidor().setText("");

    }

    private void grabarContrato() {
        if (Validacion()) {
            String codigocontrato = vista.getTxtCodigoContrato().getText();
            Instant instant = vista.getDtcFecha().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date fechacontrato = Date.valueOf(zdt.toLocalDate());
            String fkcedulacliente = vista.getTxtCedula().getText();
            String fkcodigomedidor = vista.getTxtCodigoMedidor().getText();

            ModeloContrato contrato = new ModeloContrato(codigocontrato, fechacontrato, fkcedulacliente, fkcodigomedidor);
            if (contrato.grabarContrato()) {
                JOptionPane.showMessageDialog(vista, "Contrato grabado satisfactoriamente");
                vista.getDlgCliente().setVisible(false);
                vista.getDlgContratos().setVisible(false);
                vista.getDlgMedidor().setVisible(false);
                cargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR");
            }
        }

    }

    public boolean Validacion() {
        boolean verificar = true;
        //////////////////////////////codigo contrato
        if (vista.getTxtCodigoContrato().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "el campo de codigo de contrato es obligatorio", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCodigoContrato().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CODIGO CONTRATO VACIO VACIO", " Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////////////fecha
        /* if (vista.getTxtMarca().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "El campo de marca es obligatorio", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtMarca().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "MARCA VACIA", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }*/

        ////////////////////////////////////////////////////////////////////////
        if (vista.getTxtCedula().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "El campo de cedula es obligatorio", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCedula().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CEDULA VACIA", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////////
        if (vista.getTxtCodigoMedidor().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "El campo de cedula es obligatorio", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCodigoMedidor().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CODIGO VACIO", "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        return verificar;

    }

    MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vista.getTblContratos().rowAtPoint(e.getPoint());
            st = vista.getTblContratos().getValueAt(index, 0) + "";

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

    public String ElegirContrato() {
        String idSeleccion = "";
        int fila = vista.getTblContratos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblContratos();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void editarContrato() {
        String seleccionarId = ElegirContrato();
        ModeloContrato contrato = new ModeloContrato(seleccionarId);
        List<Contratos> ps = contrato.buscarContratos();
        for (int i = 0; i < ps.size(); i++) {
            Contratos indexContratos = ps.get(i);
            String codigocontrato = indexContratos.getCodigocontrato();
            Date fechacontrato = (Date) indexContratos.getFechacontrato();
            String fkcedulacliente = indexContratos.getFkcedulacliente();
            String fkcodigomedidor = indexContratos.getFkcodigomedidor();

            muestraDialogo();

            vista.getDlgContratos().setTitle("EDITAR CONTRATO");
            vista.getTxtCodigoContrato().setText(codigocontrato);
            vista.getTxtCodigoContrato().setEditable(false);

            vista.getDtcFecha().setDate(fechacontrato);
            vista.getTxtCedula().setText(fkcedulacliente);

            vista.getTxtCodigoMedidor().setText(fkcodigomedidor);

        }
    }

    private void grabarEditarContratos() {
        if (Validacion()) {
            String codigocontrato = vista.getTxtCodigoContrato().getText();
            Instant instant = vista.getDtcFecha().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date fechacontrato = Date.valueOf(zdt.toLocalDate());
            String fkcedulacliente = vista.getTxtCedula().getText();
            String fkcodigomedidor = vista.getTxtCodigoMedidor().getText();

            ModeloContrato contrato = new ModeloContrato(codigocontrato, fechacontrato, fkcedulacliente, fkcodigomedidor);

            if (contrato.EditarContrato()) {
                JOptionPane.showMessageDialog(vista, "El Registro se ha editado satisfactoriamente");
                vista.getDlgCliente().setVisible(false);
                vista.getDlgContratos().setVisible(false);
                vista.getDlgMedidor().setVisible(false);
                cargarLista("");

            } else {
                JOptionPane.showMessageDialog(vista, "ERROR");
            }
        }

    }

    private void cerrarVentana() {
        vista.getDlgContratos().setVisible(false);

    }

    public void Delet() {
        try {
            int fila = vista.getTblContratos().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblContratos().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\t¿Desea eliminar el contrato seleccionado?\n"
                    + "Código de contrato: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Fecha de contrato: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Cédula de cliente: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Código de medidor: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                ModeloContrato con1 = new ModeloContrato();
                con1.setCodigocontrato(model.getValueAt(fila, 0).toString());
                if (con1.EliminarContrato()) {
                    JOptionPane.showMessageDialog(vista, "El contrato ha sido eliminada");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminar");
        }

    }

    ///////////////////////////////////////////////////////////
    private void ObtenerClientes() {

        vista.getDlgCliente().setSize(800, 300);
        vista.getDlgCliente().setVisible(true);
//        vista.getDlgCliente().setTitle("LISTA DE CONTRATOS");
        vista.getDlgCliente().setLocationRelativeTo(vista);
        cargarListaCli("");

    }

    private void cargarListaCli(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
        tblModel.setNumRows(0);
        List<Clientes> lista = ModeloCliente.ListarClientes(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pl -> {

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
            i.value++;

        });
    }
    //-----------------------------------------------------------------------

    public String ElegirClien() {
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

    //...............................................................................................
    public void llenarCliente() {

        String seleccionarId = ElegirClien();
        ModeloCliente cliente = new ModeloCliente(seleccionarId);
        List<Clientes> ps = cliente.buscarEditar();
        for (int i = 0; i < ps.size(); i++) {
            Clientes indexcliente = ps.get(i);

            String cedula = indexcliente.getCedula();

            vista.getDlgContratos().setVisible(true);
            vista.getDlgContratos().setSize(660, 600);
            vista.getDlgContratos().setLocationRelativeTo(vista);

            vista.getTxtCedula().setText(cedula);

        }
    }

    //---------------------------------------------------------------------
    public void MuestraMedidor() {

        vista.getDlgMedidor().setVisible(true);
        vista.getDlgMedidor().setSize(630, 320);
        vista.getDlgMedidor().setTitle("NUEVO MEDIDOR");
        vista.getDlgMedidor().setLocationRelativeTo(vista);
        cargarListaMed("");

    }

    private void cargarListaMed(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblMedidores().getModel();
        tblModel.setNumRows(0);
        List<Medidores> lista = ModeloMedidor.ListarMedidores(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pl -> {

            tblModel.addRow(new Object[ncols]);
            vista.getTblMedidores().setValueAt(pl.getCodigomedidor(), i.value, 0);
            vista.getTblMedidores().setValueAt(pl.getMarca(), i.value, 1);
            vista.getTblMedidores().setValueAt(pl.getTipo(), i.value, 2);
            vista.getTblMedidores().setValueAt(pl.getAniofabricacion(), i.value, 3);
            vista.getTblMedidores().setValueAt(pl.getCapacidad(), i.value, 4);
            vista.getTblMedidores().setValueAt(pl.getPrecio(), i.value, 5);
            i.value++;

        });
    }
    //-----------------------------------------------------------------------

    public String ElegirMed() {
        String codSeleccion = "";
        int fila = vista.getTblMedidores().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblMedidores();
            codSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return codSeleccion;
        }
        return null;
    }
    //-------------------------------------------------------------------------------------------------

    public void llenarMedidores() {

        String seleccionarId = ElegirMed();
        ModeloMedidor medidor = new ModeloMedidor(seleccionarId);
        List<Medidores> ps = medidor.buscarMedidor();
        for (int i = 0; i < ps.size(); i++) {
            Medidores indexMedidores = ps.get(i);
            String codigomedidor = indexMedidores.getCodigomedidor();

            vista.getDlgContratos().setVisible(true);
            vista.getDlgContratos().setSize(660, 600);
            vista.getDlgContratos().setLocationRelativeTo(vista);

            vista.getTxtCodigoMedidor().setText(codigomedidor);

        }
    }
    //---------------------------------------------------------------------

}
