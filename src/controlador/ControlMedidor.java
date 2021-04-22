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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.ConexionPG;
import modelo.Medidores;
import modelo.ModeloMedidor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VistaMedidores;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlMedidor {

    private ModeloMedidor modelo;
    private VistaMedidores vista;
    String st;
    boolean validarBotonA;

    public ControlMedidor(ModeloMedidor modelo, VistaMedidores vista) {
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
            editarMedidor();
            this.validarBotonA = false;
        });

        vista.getBtnEliminar().addActionListener(l -> Delet());
        vista.getBtnCancelar().addActionListener(l -> cerrarVentana());
        vista.getTxtBuscar().addKeyListener(kl);
        vista.getBtnImprimir().addActionListener(l -> ImprimirReporte());

    }

    private void validarBoton() {
        if (validarBotonA) {
            grabarMedidor();
        } else {
            grabarEditarMedidores();
        }
    }

    private void cargarLista(String aguja) {
        vista.getTblMedidores().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblMedidores().setRowHeight(30);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
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

    private void cargaListas(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblMedidores().getModel();
        tblModel.setNumRows(0);
        List<Medidores> lista = ModeloMedidor.ListarMedidores(aguja);
        lista.stream().forEach(p1 -> {
            String[] medidor = {p1.getCodigomedidor(), p1.getMarca()};

            tblModel.addRow(medidor);
        });
    }

    private void muestraDialogo() {
        vista.getTxtCodigo().setEditable(true);
        vista.getDlgMedidores().setVisible(true);
        vista.getDlgMedidores().setSize(630, 283);
        vista.getDlgMedidores().setTitle("NUEVO MEDIDOR");
        vista.getDlgMedidores().setLocationRelativeTo(vista);
        vista.getTxtCodigo().setText("");
        vista.getTxtMarca().setText("");
        vista.getDtcAnioFabriacion().setDate(null);
        vista.getCmbTipo().setSelectedIndex(0);
        vista.getTxtCapacidad().setText("");
        vista.getTxtPrecio().setText("");
    }

    private void grabarMedidor() {
        if (Validacion()) {
            String codigomedidor = vista.getTxtCodigo().getText();
            String marca = vista.getTxtMarca().getText();
            String tipo = "";
            tipo = vista.getCmbTipo().getSelectedItem().toString();
            Instant instant = vista.getDtcAnioFabriacion().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date aniofabricacion = Date.valueOf(zdt.toLocalDate());
            String capacidad = vista.getTxtCapacidad().getText();
            int precio = Integer.parseInt(vista.getTxtPrecio().getText());

            ModeloMedidor medidor = new ModeloMedidor(codigomedidor, marca, tipo, aniofabricacion, capacidad, precio);
            if (medidor.grabarMedidor()) {
                JOptionPane.showMessageDialog(vista, "Registro creado satisfactoriamente");
                cargarLista("");
                vista.getDlgMedidores().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vista, "El medidor ya se encuentra registrado");
            }
        }

    }

    public boolean Validacion() {
        boolean verificar = true;
        //////////////////////////////cedula
        if (vista.getTxtCodigo().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en CÓDIGO MEDIDOR excedido", "Código medidor erróneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCodigo().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo CÓDIGO MEDIDOR es obligatorio", " Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////////////nombres
        if (vista.getTxtMarca().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en MARCA excedido", "Marca errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtMarca().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de MARCA es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////apellidos

        if (vista.getCmbTipo().getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "El campo TIPO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////////
        if (vista.getTxtCapacidad().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Número de caracteres en CAPACIDAD excedido", "Capacidad errónea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCapacidad().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de CAPACIDAD es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtPrecio().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de PRECIO es obligatorio", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        return verificar;

    }

    MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vista.getTblMedidores().rowAtPoint(e.getPoint());
            st = vista.getTblMedidores().getValueAt(index, 0) + "";

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

    public String ElegirMedidor() {
        String idSeleccion = "";
        int fila = vista.getTblMedidores().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblMedidores();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void editarMedidor() {
        String seleccionarId = ElegirMedidor();
        ModeloMedidor medidor = new ModeloMedidor(seleccionarId);
        List<Medidores> ps = medidor.buscarMedidor();
        for (int i = 0; i < ps.size(); i++) {
            Medidores indexMedidores = ps.get(i);
            String codigomedidor = indexMedidores.getCodigomedidor();
            String marca = indexMedidores.getMarca();
            String tipo = indexMedidores.getTipo();
            Date aniofabricacion = (Date) indexMedidores.getAniofabricacion();
            String capacidad = indexMedidores.getCapacidad();
            int precio = indexMedidores.getPrecio();

            muestraDialogo();

            vista.getDlgMedidores().setTitle("EDITAR MEDIDOR");
            vista.getTxtCodigo().setEditable(false);
            vista.getTxtCodigo().setText(codigomedidor);
            vista.getTxtCodigo().setEditable(false);
            vista.getTxtMarca().setText(marca);
            vista.getCmbTipo().setSelectedItem(tipo);
            vista.getDtcAnioFabriacion().setDate(aniofabricacion);
            vista.getTxtCapacidad().setText(capacidad);
            vista.getTxtPrecio().setText(precio + "");

        }
    }

    private void grabarEditarMedidores() {
        if (Validacion()) {
            String codigomedidor = vista.getTxtCodigo().getText();
            String marca = vista.getTxtMarca().getText();
            String tipo = "";
            tipo = vista.getCmbTipo().getSelectedItem().toString();
            Instant instant = vista.getDtcAnioFabriacion().getDate().toInstant();
            ZoneId zid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
            Date aniofabricacion = Date.valueOf(zdt.toLocalDate());
            String capacidad = vista.getTxtCapacidad().getText();
            int precio = Integer.parseInt(vista.getTxtPrecio().getText());

            ModeloMedidor medidor = new ModeloMedidor(codigomedidor, marca, tipo, aniofabricacion, capacidad, precio);

            if (medidor.EditarMedidor()) {
                JOptionPane.showMessageDialog(vista, "El Registro se ha editado satisfactoriamente");
                cargarLista("");
                vista.getDlgMedidores().setVisible(false);

            } else {
                JOptionPane.showMessageDialog(vista, "ERROR");
            }
        }

    }

    private void cerrarVentana() {
        vista.getDlgMedidores().setVisible(false);

    }

    public void Delet() {
        try {
            int fila = vista.getTblMedidores().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblMedidores().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\t¿Desea eliminar el medidor seleccionada?\n"
                    + "Código de medidor: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Marca: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Tipo: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Año de fabricación: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                ModeloMedidor med1 = new ModeloMedidor();
                med1.setCodigomedidor(model.getValueAt(fila, 0).toString());
                if (med1.EliminarMedidor()) {
                    JOptionPane.showMessageDialog(vista, "El medidor ha sido eliminado");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminar");
        }

    }

    private void ImprimirReporte() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/rptMedidores.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConexion());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(ControlMedidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
