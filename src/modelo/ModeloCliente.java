/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Juann Inga
 */
public class ModeloCliente extends Clientes {

    private static ConexionPG conectar = new ConexionPG();

    public ModeloCliente() {
    }

    public ModeloCliente(String codigo_cliente) {
        super(codigo_cliente);
    }


    public ModeloCliente(String codigo_cliente, String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono) {
        super(codigo_cliente, cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono);
    }

    public String foto64() {
        String foto64 = null;

        //transformación de imagen a base 64 pgsql
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgBimage(getFoto());
            ImageIO.write(img, "PNG", bao);
            byte[] imgb = bao.toByteArray();
            foto64 = org.postgresql.util.Base64.encodeBytes(imgb);
            return foto64;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private BufferedImage imgBimage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }

    public static Image obtenImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);

    }

    public static List<Clientes> ListarClientes(String aguja) {

        try {
            String query = "SELECT * FROM clientes WHERE ";
            
            query += "UPPER(nombre) LIKE UPPER('%" + aguja + "%') OR ";
            query += "UPPER(apellido) LIKE UPPER('%" + aguja + "%') OR ";
            query += "UPPER(cedula) LIKE UPPER('%" + aguja + "%')";

            ResultSet rs = conectar.query(query);
            List<Clientes> lista = new ArrayList<Clientes>();
            byte[] bf;
            while (rs.next()) {

                Clientes cliente = new Clientes();
                cliente.setCodigo_cliente(rs.getString("codigo_cliente"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setFechanac(rs.getDate("fechanacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = org.postgresql.util.Base64.decode(bf, 0, bf.length);

                    try {
                        //Obtener la imagen
                        cliente.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        cliente.setFoto(null);
                        Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cliente.setFoto(null);
                }
                lista.add(cliente);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean grabar() {
        String sql;
        sql = "INSERT INTO clientes(codigo_cliente, cedula, nombre, apellido, genero, fechanacimiento, direccion, correo, telefono, foto)";
        sql += "VALUES('"+ getCodigo_cliente()+"','" + getCedula() + "','" + getNombre() + "','" + getApellido() + "','" + getGenero() + "','" + getFechanac() + "','" + getDireccion() + "','" + getCorreo() + "','" + getTelefono() + "','" + foto64() + "')";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<Clientes> buscarEditar() {
        try {
            String query = "select * from clientes where cedula='" + getCodigo_cliente()+ "';";
            ResultSet rs = conectar.query(query);
            List<Clientes> lista = new ArrayList<Clientes>();
            byte[] bf;
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setCedula(rs.getString("cedula"));
                cliente.setCodigo_cliente(rs.getString("codigo_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setFechanac(rs.getDate("fechanacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                bf = rs.getBytes("foto");
                
                if (bf != null) {
                    bf = org.postgresql.util.Base64.decode(bf, 0, bf.length);

                    try {
                        //Obtener la imagen
                        cliente.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        cliente.setFoto(null);
                        Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cliente.setFoto(null);
                }
                lista.add(cliente);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean Editar() {
        String sql;
        sql = "UPDATE clientes SET nombre='" + getNombre() + "', apellido='" + getApellido() + "',"
                + "genero='" + getGenero() + "', fechanacimiento='" + getFechanac() + "', direccion='" + getDireccion() + "',"
                + "correo='" + getCorreo() + "',telefono=" + getTelefono() + ", foto='" + foto64() + "'"
                + "WHERE cedula='" + getCedula()+ "';";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            return false;
        }
    }

    public boolean Eliminar() {

        String sql;
        sql = "DELETE FROM clientes WHERE cedula='" + getCedula()+ "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
