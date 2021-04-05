/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.ModeloFactura;
import modelo.Factura;
import vista.VistaFacturas;

/**
 *
 * @author Juann Inga, Jefferson Condo y Anthony Cardenas
 */
public class ControlFactura {
    
    private ModeloFactura modelo;
    private VistaFacturas vista;
    String st;

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
            }
        };

        vista.getBtnActualizarFac().addActionListener(l -> cargarLista(""));
        vista.getBtnNuevoFac().addActionListener(l -> MuestraDialog());
        vista.getBtnAceptarIn().addActionListener(l -> grabarFactura());
        vista.getBtnEditarIn().addActionListener(l -> editarFactura());
        vista.getBtnEditarIn().addActionListener(l -> Actualizar());
        vista.getBtnEliminarFac().addActionListener(l -> Delet());
        vista.getTxtBuscar().addKeyListener(kn1);
       // vista.getBtnimprimir().addActionListener(l -> ImprimirReporte());

    }

    private void cargarLista(String aguja) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblFacturas().getModel();
        tblModel.setNumRows(0);
        List<Factura> lista = ModeloFactura.listar(aguja);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblFacturas().setValueAt(p1.getCodigofactura(), i.value, 0);
            vista.getTblFacturas().setValueAt(p1.getFechafactura(), i.value, 1);
            vista.getTblFacturas().setValueAt(p1.getNombrecliente(), i.value, 2);
            vista.getTblFacturas().setValueAt(p1.getFkcedulacliente(), i.value, 3);
            vista.getTblFacturas().setValueAt(p1.getApellidocliente(), i.value, 4);
            vista.getTblFacturas().setValueAt(p1.getDireccion(), i.value, 5);
            vista.getTblFacturas().setValueAt(p1.getFkcodigocontrato(), i.value, 6);
            vista.getTblFacturas().setValueAt(p1.getCostowatts(), i.value, 7);
            vista.getTblFacturas().setValueAt(p1.getWatts(), i.value, 8);
            vista.getTblFacturas().setValueAt(p1.getTotal(), i.value, 9);
            //completar datos
            
        });
    }

    private void grabarFactura() {

        
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
        double costo_wats= Double.parseDouble(vista.getTxtCostoIn().getText());
        int watts = Integer.parseInt(vista.getTxtWattsIn().getText());
        double total = Double.parseDouble(vista.getTxtTotalIn().getText());
        
        ModeloFactura fact = new ModeloFactura(cod_fact,fecha_reg, nombre,cedula, apellido, direccion, contra, costo_wats,watts,total);
       
        if (fact.crear()) {
            cargarLista("");
            vista.getDlgFacturas().setVisible(false);
            JOptionPane.showMessageDialog(vista, "Factura Creada Existosamente");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR!!!!!!");
        }

    }

    public void Actualizar() {

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
        double costo_wats= Double.parseDouble(vista.getTxtCostoIn().getText());
        int watts = Integer.parseInt(vista.getTxtWattsIn().getText());
        double total = Double.parseDouble(vista.getTxtTotalIn().getText());
        
        ModeloFactura fact = new ModeloFactura(cod_fact,fecha_reg, nombre,cedula, apellido, direccion, contra, costo_wats,watts,total);
        if (fact.modificar()) {
            cargarLista("");
            vista.getDlgFacturas().setVisible(false);
            JOptionPane.showMessageDialog(vista, "Modificado Existosamente");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR!!!!!!");
        }

    }

    public void Delet() {
        try {
            int fila = vista.getTblFacturas().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblFacturas().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea elimianr la factura\n"
                    + "codigo: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "contrato: " + model.getValueAt(fila, 2).toString() + "\n"
                    );
            if (op == 0) {
                ModeloFactura p1 = new ModeloFactura();
                p1.setCodigofactura(model.getValueAt(fila, 0).toString());
                if (p1.Eliminar()) {
                    JOptionPane.showMessageDialog(vista, "Factura eliminada");
                    cargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
        }

    }

    private void MuestraDialog() {
        vista.getTxtCedulaIn().setEditable(true);
        vista.getDlgFacturas().setVisible(true);
        vista.getDlgFacturas().setSize(660,600);
        vista.getDlgFacturas().setTitle("NUEVA PERSONA");
        vista.getDlgFacturas().setLocationRelativeTo(vista);
        vista.getTxtCodigoFacturaIn().setText("");
        vista.getDtcFechaIn().setDate(null);
        vista.getTxtNombreIn().setText("");
        vista.getTxtCedulaIn().setText("");
        vista.getTxtApellidoIn().setText("");
        vista.getTxtDireccionIn().setText("");
        vista.getTxtCodigoContratoIn().setText("");
        vista.getTxtCostoIn().setText("");
        vista.getTxtWattsIn().setText("");
        vista.getTxtTotalIn().setText("");
        vista.getBtnAceptarIn().setVisible(true);
        

    }

   

//    private void ImprimirReporte() {
//        ConexionPG con = new ConexionPG();
//        double costo_wats=100.0;
//        try {
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/rpt_Factura.jasper"));
//            //JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
//            String aguja= vista.getTxtbuscar().getText();
//            Map<String,Object> parametros= new HashMap<String, Object>();
//            parametros.put("aguja","%"+aguja+"%");
//            parametros.put("costo_wats",costo_wats);
//            
//            JasperPrint jp = JasperFillManager.fillReport(jr,parametros, con.getCon());
//            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
//
//        } catch (JRException ex) {
//            Logger.getLogger(ControlFactura.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    //// metodos para cambiar imagenes
    MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vista.getTblFacturas().rowAtPoint(e.getPoint());
            st = vista.getTblFacturas().getValueAt(index, 0) + "";

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
            String contra= indexfact.getFkcodigocontrato();
            double costo_wats = indexfact.getCostowatts();
            int watts = indexfact.getWatts();
            double total = indexfact.getTotal();
           
            
            vista.getDlgFacturas().setVisible(true);
            vista.getDlgFacturas().setSize(660,600);
            vista.getDlgFacturas().setTitle("EDITAR PERSONA");
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
            vista.getTxtCostoIn().setText(costo_wats+"");
            vista.getTxtWattsIn().setText(watts+"");
            vista.getTxtTotalIn().setText(total+"");
            vista.getBtnAceptarIn().setVisible(false);
            vista.getBtnEditarIn().setVisible(true);
               
        }
    }
    
    
    
}
