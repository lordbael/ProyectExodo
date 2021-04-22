/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteimagen;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class reporteimagen {
    //direccion para la imagen
    private final String logotipo="/reporte/minilogo.png";

 public void Ver_Reporte(){
     JasperReport repor;
     JasperPrint re;

     try{
       //se carga el archivo de jasper
       URL  in=this.getClass().getResource("/reporte/rptFactura.jasper");
       repor=(JasperReport)JRLoader.loadObject(in);
       //parametros de entrada
       Map parametros = new HashMap();
       parametros.clear();
       parametros.put("logo", this.getClass().getResourceAsStream(logotipo));
       /* esto es para reportes con conexion a base de datos*/
       //re = JasperFillManager.fillReport(repor,parametros,CONEXION_BASE_DE_DATOS);

       //se crea el reporte con un origen de datos VACIO
       re = JasperFillManager.fillReport(repor, parametros, new JREmptyDataSource());
       //se muestra el reporte
       JasperViewer.viewReport(re,false);
        }catch (JRException E){

      }

    }
}

