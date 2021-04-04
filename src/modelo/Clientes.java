/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Juann Inga
 */
public class Clientes extends Persona{
    
    private String codigo_cliente;

    public Clientes() {
    }

    public Clientes(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Clientes(String codigo_cliente, String cedula, String nombre, String apellido, String genero, Date fechanac, String direccion, String correo, String telefono) {
        super(cedula, nombre, apellido, genero, fechanac, direccion, correo, telefono);
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
}
