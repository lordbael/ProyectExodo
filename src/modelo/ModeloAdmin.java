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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author Juann Inga,Jefferson condo,Antony Cardenas
 */
public class ModeloAdmin extends Admin {
    
    
    private static ConexionPG con = new ConexionPG();
    
    public ModeloAdmin(String cod_Admin, String usuario, String contrasenia) {
        super(cod_Admin, usuario, contrasenia);
    }
    public ModeloAdmin(String idPersona) {
        super(idPersona);
    }

    public ModeloAdmin(String cod_Admin, String cedula, String nombre, String apellido, String genero, java.util.Date fechanac, String direccion, String correo, String telefono,String usuario, String contrasenia) {
        super(cod_Admin, usuario, contrasenia, cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono);
    }

    public ModeloAdmin() {
    }
    
   
    
    public String foto64(){
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


    public boolean crear() {
        String sql;
        sql = "INSERT INTO admin(codigo_usuario, cedula, nombre, apellido, genero, fechanacimiento, direccion, telefono, correo, foto, tipo_usuario, contrasenia)";
        sql += "VALUES ('" + getCod_Admin() + "','" + getCedula() + "', '" + getNombre() + "','" + getApellido() + "','" + getGenero()+ "', '" + getFechanac() + "', '" + getDireccion() + "','" + getTelefono() + "','" + getCorreo() + "','" + foto64() + "','" + getUsuario()+ "','" + getContrasenia()+ "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    ;
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
    
    public boolean modificar() {
        String sql;
        sql = "UPDATE admin\n"
                + "   SET  nombre='" + getNombre()+ "', apellido='" + getApellido() + "', genero='" + getGenero() + "', fechanacimiento='" + getFechanac()+ "', \n"
                + "       direccion='" + getDireccion() + "', telefono='" + getTelefono() + "', correo='" + getCorreo() + "', foto='" + foto64() + "', tipo_usuario='" +getUsuario() + "', contrasenia='" + getContrasenia() + "'\n"
                + " WHERE codigo_usuario='" + getCod_Admin()+ "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {

            return false;
        }
    }
    
    public static List<Admin> listar(String aguja) {

        try {
            String query = "SELECT codigo_usuario,cedula, nombre, apellido, genero, fechanacimiento, direccion, telefono, correo, foto, tipo_usuario, contrasenia  FROM admin WHERE ";

            query += "upper(nombre) LIKE upper('%" + aguja + "%') OR ";
            query += "upper(apellido) LIKE upper('%" + aguja + "%') OR ";
            query += "upper(codigo_usuario) LIKE upper('%" + aguja + "%') OR ";
            query += "upper(cedula) LIKE upper('%" + aguja + "%')";
            ResultSet rs = con.query(query);
            List<Admin> lista = new ArrayList<Admin>();
            byte[] bf;
            while (rs.next()) {

                Admin persona = new Admin();
                persona.setCod_Admin(rs.getString("codigo_usuario"));
                persona.setCedula(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setGenero(rs.getString("genero"));
                persona.setFechanac(rs.getDate("fechanacimiento"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setUsuario(rs.getString("tipo_usuario"));
                persona.setContrasenia(rs.getString("contrasenia"));
                
              
                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        persona.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);

            }

            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    ;
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
    
    public List<Admin> buscar() {
        try {
            String query = "select * from admin where codigo_usuario='" + getCod_Admin()+ "';";
            ResultSet rs = con.query(query);
            List<Admin> lista = new ArrayList<Admin>();
            byte[] bf;
            while (rs.next()) {
                Admin persona = new Admin();
                
                persona.setCod_Admin(rs.getString("codigo_usuario"));
                persona.setCedula(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setGenero(rs.getString("genero"));
                persona.setFechanac(rs.getDate("fechanacimiento"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setUsuario(rs.getString("tipo_usuario"));
                persona.setContrasenia(rs.getString("contrasenia"));
                
                
                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = org.postgresql.util.Base64.decode(bf, 0, bf.length);

                    try {
                        //Obtener la imagen
                        persona.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    

    public boolean Eliminar() {

        String sql;
        sql = "DELETE FROM admin WHERE codigo_usuario='" + getCod_Admin() + "'";
        
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    };
    
}
