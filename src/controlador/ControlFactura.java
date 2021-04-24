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
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Clientes;
import modelo.ConexionPG;
import modelo.Contratos;
import modelo.ModeloFactura;
import modelo.Factura;
import modelo.ModeloCliente;
import modelo.ModeloContrato;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VistaFacturas;
import vista.VistaInicio;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlFactura {

    private ModeloFactura modelo;
    private VistaFacturas vista;
    String st;
    boolean validarBotonA;
    public static VistaInicio vi;
    public static double costo_wats = 0.12;
    private final String logotipo = "/reporte/minilogo.png";

    public ControlFactura(ModeloFactura modelo, VistaFacturas vista) {
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
                cargarListaCli(vista.getTxtBuscarClientes().getText());
                cargarListaContrato(vista.getTxtBuscarContratos().getText());

            }
        };

        //Eventos Vista Principal
        vista.getBtnActualizarFac().addActionListener(l -> cargarLista(""));

        vista.getBtnNuevoFac().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialog();
        });
        vista.getBtnAceptarIn().addActionListener(l -> validarBoton());

        vista.getBtnEditarFac().addActionListener((ActionEvent l) -> {
            editarFactura();
            this.validarBotonA = false;
        });

        vista.getBtnEliminarFac().addActionListener(l -> Delet());
        vista.getBtnCancelarIn().addActionListener(l -> cerrarVentana());
        //---BUSCAR FACTURA
        vista.getTxtBuscar().addKeyListener(kn1);
        //--BUSCAR CLIENTES
        vista.getTxtBuscarClientes().addKeyListener(kn1);
        //--BUSCAR CONTRATOS
        vista.getTxtBuscarContratos().addKeyListener(kn1);

        vista.getBtnBuscarDjg().addActionListener(l -> llenarCliente());

        vista.getBtnBuscarClientes().addActionListener(l -> MuestraListaClientes());
        //-------------------------------------------------------------------------
        vista.getBtnSeleccionarContrato().addActionListener(l -> LlenarContrato());
        vista.getBtnBuscarContra().addActionListener(l -> MuestraContratos());
        vista.getBtnImprimirFac().addActionListener(l -> ImprimirReporteFactura());
        vista.getBtnExportarFac().addActionListener(l -> ExportarReporte());

    }

    private void validarBoton() {
        if (validarBotonA) {
            grabarFactura();
        } else {
            grabarEditarFactura();
        }
    }

    private void cargarLista(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblFacturas().getModel();
        vista.getTblFacturas().setRowHeight(30);
        tblModel.setNumRows(0);
        List<Factura> lista = ModeloFactura.listar(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblFacturas().setValueAt(p1.getCodigofactura(), i.value, 0);
            vista.getTblFacturas().setValueAt(p1.getFechafactura(), i.value, 1);
            vista.getTblFacturas().setValueAt(p1.getFkcodigocontrato(), i.value, 2);
            vista.getTblFacturas().setValueAt(p1.getFkcedulacliente(), i.value, 3);
            vista.getTblFacturas().setValueAt(p1.getNombrecliente(), i.value, 4);
            vista.getTblFacturas().setValueAt(p1.getApellidocliente(), i.value, 5);
            vista.getTblFacturas().setValueAt(p1.getDireccion(), i.value, 6);
            vista.getTblFacturas().setValueAt(p1.getCostowatts(), i.value, 7);
            vista.getTblFacturas().setValueAt(p1.getWatts(), i.value, 8);
            vista.getTblFacturas().setValueAt(p1.getTotal(), i.value, 9);
            //completar datos
            i.value++;

        });
    }

    private void MuestraDialog() {
        vista.getTxtCodigoFacturaIn().setEditable(true);
        vista.getDlgFacturas().setVisible(true);
        vista.getDlgFacturas().setSize(500, 530);
        vista.getDlgFacturas().setTitle("NUEVA FACTURA");
        vista.getDlgFacturas().setLocationRelativeTo(vista);
        vista.getTxtCodigoFacturaIn().setText("");
        vista.getDtcFechaIn().setDate(null);
        vista.getTxtNombreIn().setText("");
        vista.getTxtCedulaIn().setText("");
        vista.getTxtApellidoIn().setText("");
        vista.getTxtDireccionIn().setText("");
        vista.getTxtCodigoContratoIn().setText("");
        vista.getTxtCostoIn().setText("" + costo_wats);
        vista.getTxtCostoIn().setEditable(false);
        vista.getTxtWattsIn().setText("");
        vista.getTxtTotalIn().setText("");
        vista.getTxtTotalIn().setEditable(false);

    }

    private void grabarFactura() {
        double total;
        String cod_fact = vista.getTxtCodigoFacturaIn().getText();

        Instant instante = vista.getDtcFechaIn().getDate().toInstant();
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        Date fecha_reg = Date.valueOf(zdt.toLocalDate());

        String nombre = vista.getTxtNombreIn().getText();
        String cedula = vista.getTxtCedulaIn().getText();
        String apellido = vista.getTxtApellidoIn().getText();
        String direccion = vista.getTxtDireccionIn().getText();
        String contra = vista.getTxtCodigoContratoIn().getText();
        costo_wats = Double.parseDouble(vista.getTxtCostoIn().getText());
        int watts = Integer.parseInt(vista.getTxtWattsIn().getText());
        total = costo_wats * watts;
        vista.getTxtTotalIn().setText("" + total);

        ModeloFactura fact = new ModeloFactura(cod_fact, fecha_reg, nombre, cedula, apellido, direccion, contra, costo_wats, watts, total);

        if (fact.crear()) {
            cargarLista("");
            vista.getDlgClientes().setVisible(false);
            vista.getDlgContratos().setVisible(false);
            vista.getDlgFacturas().setVisible(false);
            JOptionPane.showMessageDialog(vista, "Registro creado satisfactoriamente");

        } else {
            JOptionPane.showMessageDialog(vista, "La factura ya se encuentra registrada");
        }

    }

    private void cerrarVentana() {
        vista.getDlgFacturas().setVisible(false);

    }

    public void editarFactura() {
        String seleccionarId = Elegir();
        ModeloFactura fact = new ModeloFactura(seleccionarId);
        List<Factura> ps = fact.buscar();
        for (int i = 0; i < ps.size(); i++) {
            Factura indexfact = ps.get(i);
            String idfact = indexfact.getCodigofactura();
            Date fecha = (Date) indexfact.getFechafactura();
            String nombre = indexfact.getNombrecliente();
            String cedula = indexfact.getFkcedulacliente();
            String apellido = indexfact.getApellidocliente();
            String direccion = indexfact.getDireccion();
            String contra = indexfact.getFkcodigocontrato();
            double costo_wats = indexfact.getCostowatts();
            int watts = indexfact.getWatts();
            double total = indexfact.getTotal();

            MuestraDialog();

            vista.getDlgFacturas().setTitle("EDITAR FACTURA");
            vista.getDlgFacturas().setLocationRelativeTo(vista);
            ///--------------------------------------------------
            vista.getTxtCodigoFacturaIn().setText(idfact);
            vista.getTxtCodigoFacturaIn().setEditable(false);
            vista.getTxtNombreIn().setText(nombre);
            vista.getTxtCedulaIn().setText(cedula);
            vista.getTxtApellidoIn().setText(apellido);
            vista.getDtcFechaIn().setDate(fecha);
            vista.getTxtDireccionIn().setText(direccion);
            vista.getTxtCodigoContratoIn().setText(contra);
            vista.getTxtCostoIn().setText(costo_wats + "");
            vista.getTxtWattsIn().setText(watts + "");
            vista.getTxtTotalIn().setText(total + "");
            vista.getTxtCostoIn().setEditable(false);
            vista.getTxtTotalIn().setEditable(false);

        }
    }

    public void grabarEditarFactura() {
        double total;
        String cod_fact = vista.getTxtCodigoFacturaIn().getText();

        Instant instante = vista.getDtcFechaIn().getDate().toInstant();
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        Date fecha_reg = Date.valueOf(zdt.toLocalDate());

        String nombre = vista.getTxtNombreIn().getText();
        String cedula = vista.getTxtCedulaIn().getText();
        String apellido = vista.getTxtApellidoIn().getText();
        String direccion = vista.getTxtDireccionIn().getText();
        String contra = vista.getTxtCodigoContratoIn().getText();
        costo_wats = Double.parseDouble(vista.getTxtCostoIn().getText());
        int watts = Integer.parseInt(vista.getTxtWattsIn().getText());
        total = costo_wats * watts;
        vista.getTxtTotalIn().setText("" + total);

        ModeloFactura fact = new ModeloFactura(cod_fact, fecha_reg, nombre, cedula, apellido, direccion, contra, costo_wats, watts, total);

        if (fact.modificar()) {
            cargarLista("");
            vista.getDlgClientes().setVisible(false);
            vista.getDlgContratos().setVisible(false);
            vista.getDlgFacturas().setVisible(false);
            JOptionPane.showMessageDialog(vista, "El registro se ha editado satisfactoriamente");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }

    }

    public void Delet() {
        try {
            int fila = vista.getTblFacturas().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblFacturas().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\t¿Desea eliminar la factura?\n"
                    + "Código Factura: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Fecha: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Código de contrato: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Cédula cliente: " + model.getValueAt(fila, 3).toString() + "\n"
            );
            if (op == 0) {
                ModeloFactura p1 = new ModeloFactura();
                p1.setCodigofactura(model.getValueAt(fila, 0).toString());
                if (p1.Eliminar()) {
                    JOptionPane.showMessageDialog(vista, "La factura ha sido eliminada");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminar");
        }

    }

    //// metodos para cambiar imagenes
    MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vista.getTblFacturas().rowAtPoint(e.getPoint());
            st = vista.getTblFacturas().getValueAt(index, 0) + "";

            int indexCli = vista.getTblClientes().rowAtPoint(e.getPoint());
            st = vista.getTblClientes().getValueAt(indexCli, 0) + "";

            int indexCont = vista.getTblClientes().rowAtPoint(e.getPoint());
            st = vista.getTblContratos().getValueAt(indexCont, 0) + "";

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
        int fila = vista.getTblFacturas().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Primero debe seleccionar la fila que desea editar");
        } else {
            JTable tabla = vista.getTblFacturas();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    ///----------------------eventos externos Clientes------------------------------
    public void MuestraListaClientes() {
        vista.getDlgClientes().setSize(1000, 500);
        vista.getDlgClientes().setTitle("LISTA DE CLIENTES");
        vista.getDlgClientes().setVisible(true);
        vista.getDlgClientes().setLocationRelativeTo(vista);
        cargarListaCli("");

    }

    private void cargarListaCli(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
        vista.getTblClientes().setRowHeight(30);
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
            //vista.getTblClientes().setValueAt(pl.getTelefono(), i.value, 8);
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
////-------------------------------------------------

    public void llenarCliente() {

        String seleccionarId = ElegirClien();
        ModeloCliente cliente = new ModeloCliente(seleccionarId);
        List<Clientes> ps = cliente.buscarEditar();
        for (int i = 0; i < ps.size(); i++) {
            Clientes indexcliente = ps.get(i);
            String nombre = indexcliente.getNombre();
            String apellido = indexcliente.getApellido();
            String cedula = indexcliente.getCedula();
            String direccion = indexcliente.getDireccion();

            vista.getDlgFacturas().setVisible(true);
            vista.getDlgClientes().setSize(1000, 500);
            vista.getDlgFacturas().setLocationRelativeTo(vista);
            vista.getTxtNombreIn().setText(nombre);
            vista.getTxtCedulaIn().setText(cedula);
            vista.getTxtApellidoIn().setText(apellido);
            vista.getTxtDireccionIn().setText(direccion);
            vista.getDlgClientes().setVisible(false);

        }
    }
///eventos externos ----------------CONTRATOS-----------------------------

    public void MuestraContratos() {
        vista.getDlgContratos().setSize(1000, 500);
        vista.getDlgContratos().setTitle("LISTA DE CONTRATOS");
        vista.getDlgContratos().setVisible(true);
        vista.getDlgContratos().setLocationRelativeTo(vista);
        cargarListaContrato("");
    }

    private void cargarListaContrato(String aguja) {
        vista.getTblContratos().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblContratos().setRowHeight(30);
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

    public void LlenarContrato() {
        String seleccionarId = ElegirContrato();
        ModeloContrato contrato = new ModeloContrato(seleccionarId);
        List<Contratos> ps = contrato.buscarContratos();
        for (int i = 0; i < ps.size(); i++) {
            Contratos indexContratos = ps.get(i);
            String codigocontrato = indexContratos.getCodigocontrato();
            vista.getDlgFacturas().setVisible(true);
            vista.getDlgContratos().setSize(1000, 500);
            vista.getDlgContratos().setTitle("LISTA CONTRATOS");
            vista.getDlgContratos().setLocationRelativeTo(vista);
            vista.getTxtCodigoContratoIn().setText(codigocontrato);
            vista.getDlgContratos().setVisible(false);

        }
    }

    private void ImprimirReporteFactura() {
        ConexionPG con = new ConexionPG();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/rptFactura.jasper"));
            String aguja = vista.getTxtBuscar().getText();
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("aguja", "%" + aguja + "%");
            parametros.put("logo", this.getClass().getResourceAsStream(logotipo));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getConexion());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(ControlFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ExportarReporte() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/rptFacturaEstadistico.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("logo", this.getClass().getResourceAsStream(logotipo));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getConexion());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
