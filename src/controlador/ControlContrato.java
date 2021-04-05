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
import modelo.Contratos;
import modelo.Medidores;
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
        vista.getTblContratos().setRowHeight(100);
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
        vista.getDlgContratos().setSize(420, 550);
        vista.getDlgContratos().setTitle("NUEVO CONTRATO");
        vista.getDlgContratos().setLocationRelativeTo(vista);
        vista.getTxtCodigoContrato().setText("");
        vista.getDtcFecha().setDate(null);
        vista.getTxtCedula().setText("");
        vista.getTxtCodigoMedidor().setText("");

    }

    private void grabarContrato() {
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
            cargarLista("");
            vista.getDlgContratos().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }

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
            cargarLista("");
            vista.getDlgContratos().setVisible(false);

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }

    }

    private void cerrarVentana() {
        vista.getDlgContratos().setVisible(false);

    }

    public void Delet() {
        try {
            int fila = vista.getTblContratos().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblContratos().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\t¿Desea eliminar el medidor seleccionada?\n"
                    + "codigocontrato: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "fechacontrato: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "fkcedulacliente: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "fkcodigomedidor: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                ModeloContrato con1 = new ModeloContrato();
                con1.setCodigocontrato(model.getValueAt(fila, 0).toString());
                if (con1.EliminarContrato()) {
                    JOptionPane.showMessageDialog(vista, "El medidor ha sido eliminada");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
        }

    }

}
