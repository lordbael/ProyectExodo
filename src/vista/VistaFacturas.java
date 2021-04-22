/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Juann Inga
 */
public class VistaFacturas extends javax.swing.JInternalFrame {
    
    public VistaFacturas() {
        initComponents();
        this.setSize(1301, 665);
        this.setTitle("Facturas");
    }

    public JButton getBtnAceptarIn() {
        return btnAceptarIn;
    }

    public void setBtnAceptarIn(JButton btnAceptarIn) {
        this.btnAceptarIn = btnAceptarIn;
    }

    public JButton getBtnActualizarFac() {
        return btnActualizarFac;
    }

    public void setBtnActualizarFac(JButton btnActualizarFac) {
        this.btnActualizarFac = btnActualizarFac;
    }

    public JButton getBtnBuscarClientes() {
        return btnBuscarClientes;
    }

    public void setBtnBuscarClientes(JButton btnBuscarClientes) {
        this.btnBuscarClientes = btnBuscarClientes;
    }

    public JButton getBtnBuscarContra() {
        return btnBuscarContra;
    }

    public void setBtnBuscarContra(JButton btnBuscarContra) {
        this.btnBuscarContra = btnBuscarContra;
    }

    public JButton getBtnCancelarIn() {
        return btnCancelarIn;
    }

    public void setBtnCancelarIn(JButton btnCancelarIn) {
        this.btnCancelarIn = btnCancelarIn;
    }

    public JButton getBtnEditarFac() {
        return btnEditarFac;
    }

    public void setBtnEditarFac(JButton btnEditarFac) {
        this.btnEditarFac = btnEditarFac;
    }

    public JButton getBtnEliminarFac() {
        return btnEliminarFac;
    }

    public void setBtnEliminarFac(JButton btnEliminarFac) {
        this.btnEliminarFac = btnEliminarFac;
    }

    public JButton getBtnExportarFac() {
        return btnExportarFac;
    }

    public void setBtnExportarFac(JButton btnExportarFac) {
        this.btnExportarFac = btnExportarFac;
    }

    public JButton getBtnImprimirFac() {
        return btnImprimirFac;
    }

    public void setBtnImprimirFac(JButton btnImprimirFac) {
        this.btnImprimirFac = btnImprimirFac;
    }

    public JButton getBtnNuevoFac() {
        return btnNuevoFac;
    }

    public void setBtnNuevoFac(JButton btnNuevoFac) {
        this.btnNuevoFac = btnNuevoFac;
    }

    public JDialog getDlgFacturas() {
        return dlgFacturas;
    }

    public void setDlgFacturas(JDialog dlgFacturas) {
        this.dlgFacturas = dlgFacturas;
    }

    public JDateChooser getDtcFechaIn() {
        return dtcFechaIn;
    }

    public void setDtcFechaIn(JDateChooser dtcFechaIn) {
        this.dtcFechaIn = dtcFechaIn;
    }

    public JTable getTblFacturas() {
        return tblFacturas;
    }

    public void setTblFacturas(JTable tblFacturas) {
        this.tblFacturas = tblFacturas;
    }

    public JTextField getTxtApellidoIn() {
        return txtApellidoIn;
    }

    public void setTxtApellidoIn(JTextField txtApellidoIn) {
        this.txtApellidoIn = txtApellidoIn;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtCedulaIn() {
        return txtCedulaIn;
    }

    public void setTxtCedulaIn(JTextField txtCedulaIn) {
        this.txtCedulaIn = txtCedulaIn;
    }

    public JTextField getTxtCodigoContratoIn() {
        return txtCodigoContratoIn;
    }

    public void setTxtCodigoContratoIn(JTextField txtCodigoContratoIn) {
        this.txtCodigoContratoIn = txtCodigoContratoIn;
    }

    public JTextField getTxtCodigoFacturaIn() {
        return txtCodigoFacturaIn;
    }

    public void setTxtCodigoFacturaIn(JTextField txtCodigoFacturaIn) {
        this.txtCodigoFacturaIn = txtCodigoFacturaIn;
    }

    public JTextField getTxtCostoIn() {
        return txtCostoIn;
    }

    public void setTxtCostoIn(JTextField txtCostoIn) {
        this.txtCostoIn = txtCostoIn;
    }

    public JTextField getTxtDireccionIn() {
        return txtDireccionIn;
    }

    public void setTxtDireccionIn(JTextField txtDireccionIn) {
        this.txtDireccionIn = txtDireccionIn;
    }

    public JTextField getTxtNombreIn() {
        return txtNombreIn;
    }

    public void setTxtNombreIn(JTextField txtNombreIn) {
        this.txtNombreIn = txtNombreIn;
    }

    public JTextField getTxtTotalIn() {
        return txtTotalIn;
    }

    public void setTxtTotalIn(JTextField txtTotalIn) {
        this.txtTotalIn = txtTotalIn;
    }

    public JTextField getTxtWattsIn() {
        return txtWattsIn;
    }

    public void setTxtWattsIn(JTextField txtWattsIn) {
        this.txtWattsIn = txtWattsIn;
    }

 //----------------------------opciones externas------------------------
    public JDialog getDlgClientes() {
        return dlgClientes;
    }

    public void setDlgClientes(JDialog dlgClientes) {
        this.dlgClientes = dlgClientes;
    }

    public JDialog getDlgContratos() {
        return dlgContratos;
    }

    public void setDlgContratos(JDialog dlgContratos) {
        this.dlgContratos = dlgContratos;
    }

    public JButton getBtnBuscar() {
        return btnBuscarDjg;
    }

    public JButton getBtnBuscarDjg() {
        return btnBuscarDjg;
    }

    public void setBtnBuscarDjg(JButton btnBuscarDjg) {
        this.btnBuscarDjg = btnBuscarDjg;
    }

    public JTable getTblClientes() {
        return tblClientes;
    }

    public void setTblClientes(JTable tblClientes) {
        this.tblClientes = tblClientes;
    }

    

    

    public JTextField getTxtBuscarClientes() {
        return txtBuscarClientes;
    }

    public void setTxtBuscarClientes(JTextField txtBuscarClientes) {
        this.txtBuscarClientes = txtBuscarClientes;
    }
    
    ///-----------------opcion externa 2------------------------------------------

    public JButton getBtnSeleccionarContrato() {
        return btnSeleccionarContrato;
    }

    public void setBtnSeleccionarContrato(JButton btnSeleccionarContrato) {
        this.btnSeleccionarContrato = btnSeleccionarContrato;
    }

    public JTable getTblContratos() {
        return tblContratos;
    }

    public void setTblContratos(JTable tblContratos) {
        this.tblContratos = tblContratos;
    }

    public JTextField getTxtBuscarContratos() {
        return txtBuscarContratos;
    }

    public void setTxtBuscarContratos(JTextField txtBuscarContratos) {
        this.txtBuscarContratos = txtBuscarContratos;
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgFacturas = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtCodigoFacturaIn = new javax.swing.JTextField();
        txtCodigoContratoIn = new javax.swing.JTextField();
        dtcFechaIn = new com.toedter.calendar.JDateChooser();
        txtNombreIn = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtApellidoIn = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtDireccionIn = new javax.swing.JTextField();
        btnBuscarClientes = new javax.swing.JButton();
        txtCedulaIn = new javax.swing.JTextField();
        btnBuscarContra = new javax.swing.JButton();
        txtCostoIn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtWattsIn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotalIn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAceptarIn = new javax.swing.JButton();
        btnCancelarIn = new javax.swing.JButton();
        dlgClientes = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscarClientes = new javax.swing.JTextField();
        btnBuscarDjg = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        dlgContratos = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtBuscarContratos = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnSeleccionarContrato = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblContratos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacturas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNuevoFac = new javax.swing.JButton();
        btnActualizarFac = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnEditarFac = new javax.swing.JButton();
        btnEliminarFac = new javax.swing.JButton();
        btnExportarFac = new javax.swing.JButton();
        btnImprimirFac = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jPanel10.setBackground(new java.awt.Color(166, 138, 163));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel34.setText("Código Factura:");

        jLabel35.setText("Código Contrato:");

        jLabel36.setText("Cédula:");

        jLabel37.setText("Nombre:");

        jLabel41.setText("Fecha Factura:");

        txtCodigoFacturaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoFacturaInActionPerformed(evt);
            }
        });

        jLabel42.setText("Apellido:");

        jLabel43.setText("Dirección:");

        btnBuscarClientes.setText("Buscar Cliente");

        btnBuscarContra.setText("Buscar Contrato");

        txtCostoIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoInActionPerformed(evt);
            }
        });

        jLabel3.setText("Costo Watts:");

        jLabel4.setText("Watts:");

        jLabel5.setText("Total:");

        jLabel2.setText("$");

        jLabel6.setText("$");

        jLabel7.setText("kw/h");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoFacturaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtcFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionIn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtNombreIn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCostoIn, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtCodigoContratoIn)
                            .addComponent(txtWattsIn)
                            .addComponent(txtTotalIn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtCodigoFacturaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtcFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(btnBuscarClientes))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtCodigoContratoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarContra))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtWattsIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnAceptarIn.setText("Aceptar");
        btnAceptarIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarInActionPerformed(evt);
            }
        });

        btnCancelarIn.setText("Cancelar");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptarIn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarIn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarIn)
                    .addComponent(btnAceptarIn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgFacturasLayout = new javax.swing.GroupLayout(dlgFacturas.getContentPane());
        dlgFacturas.getContentPane().setLayout(dlgFacturasLayout);
        dlgFacturasLayout.setHorizontalGroup(
            dlgFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgFacturasLayout.setVerticalGroup(
            dlgFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(166, 138, 163));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscarDjg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486564411-checkmark_81522.png"))); // NOI18N
        btnBuscarDjg.setText("Seleccionar");
        btnBuscarDjg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDjgActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchmagnifierinterfacesymbol1_79893.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarDjg)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarDjg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarClientes)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Código Cliente", "Nombre", "Apellido", "Genero", "Fecha/Nac", "Dirección", "Correo", "Teléfono"
            }
        ));
        jScrollPane2.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dlgClientesLayout = new javax.swing.GroupLayout(dlgClientes.getContentPane());
        dlgClientes.getContentPane().setLayout(dlgClientesLayout);
        dlgClientesLayout.setHorizontalGroup(
            dlgClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgClientesLayout.setVerticalGroup(
            dlgClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(166, 138, 163));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchmagnifierinterfacesymbol1_79893.png"))); // NOI18N

        btnSeleccionarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486564411-checkmark_81522.png"))); // NOI18N
        btnSeleccionarContrato.setText("Seleccionar");
        btnSeleccionarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionarContrato)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarContratos)
                    .addComponent(btnSeleccionarContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Contrato", "Fecha Contrato", "Cédula", "Codigo Medidor"
            }
        ));
        jScrollPane3.setViewportView(tblContratos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgContratosLayout = new javax.swing.GroupLayout(dlgContratos.getContentPane());
        dlgContratos.getContentPane().setLayout(dlgContratosLayout);
        dlgContratosLayout.setHorizontalGroup(
            dlgContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgContratosLayout.setVerticalGroup(
            dlgContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBackground(new java.awt.Color(100, 64, 125));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facturas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Factura", "Fecha Factura", "Código Contrato", "Cédula", "Nombre", "Apellido", "Dirección", "Costo/Watts", "Watts", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblFacturas);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNuevoFac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevoFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nuevo.png"))); // NOI18N
        btnNuevoFac.setText("Nuevo Registro");

        btnActualizarFac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizarFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/actualizar.png"))); // NOI18N
        btnActualizarFac.setText("Actualizar");
        btnActualizarFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarFacActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnEditarFac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditarFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
        btnEditarFac.setText("Editar");
        btnEditarFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFacActionPerformed(evt);
            }
        });

        btnEliminarFac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar.png"))); // NOI18N
        btnEliminarFac.setText("Eliminar");

        btnExportarFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exportar.png"))); // NOI18N

        btnImprimirFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/imprimir.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchmagnifierinterfacesymbol1_79893.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(67, 67, 67)
                .addComponent(btnNuevoFac)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarFac)
                .addGap(18, 18, 18)
                .addComponent(btnEditarFac, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarFac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(btnExportarFac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirFac)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportarFac)
                            .addComponent(btnImprimirFac, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNuevoFac)
                                .addComponent(btnActualizarFac)
                                .addComponent(btnEditarFac)
                                .addComponent(btnEliminarFac)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoFacturaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoFacturaInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFacturaInActionPerformed

    private void txtCostoInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoInActionPerformed

    private void btnAceptarInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarInActionPerformed

    private void btnActualizarFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarFacActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnEditarFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarFacActionPerformed

    private void btnBuscarDjgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDjgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarDjgActionPerformed

    private void btnSeleccionarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarContratoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarIn;
    private javax.swing.JButton btnActualizarFac;
    private javax.swing.JButton btnBuscarClientes;
    private javax.swing.JButton btnBuscarContra;
    private javax.swing.JButton btnBuscarDjg;
    private javax.swing.JButton btnCancelarIn;
    private javax.swing.JButton btnEditarFac;
    private javax.swing.JButton btnEliminarFac;
    private javax.swing.JButton btnExportarFac;
    private javax.swing.JButton btnImprimirFac;
    private javax.swing.JButton btnNuevoFac;
    private javax.swing.JButton btnSeleccionarContrato;
    private javax.swing.JDialog dlgClientes;
    private javax.swing.JDialog dlgContratos;
    private javax.swing.JDialog dlgFacturas;
    private com.toedter.calendar.JDateChooser dtcFechaIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblContratos;
    private javax.swing.JTable tblFacturas;
    private javax.swing.JTextField txtApellidoIn;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarClientes;
    private javax.swing.JTextField txtBuscarContratos;
    private javax.swing.JTextField txtCedulaIn;
    private javax.swing.JTextField txtCodigoContratoIn;
    private javax.swing.JTextField txtCodigoFacturaIn;
    private javax.swing.JTextField txtCostoIn;
    private javax.swing.JTextField txtDireccionIn;
    private javax.swing.JTextField txtNombreIn;
    private javax.swing.JTextField txtTotalIn;
    private javax.swing.JTextField txtWattsIn;
    // End of variables declaration//GEN-END:variables
}
