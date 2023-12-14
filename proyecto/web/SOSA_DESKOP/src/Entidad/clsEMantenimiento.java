/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author ORDENADOR
 */
public class clsEMantenimiento {
    private int id_maquina;
    private int emp_con;
    private String numero;
    private String tipo;
    private String estado;
    private String observaciones;
    private String fecha;
    
    private String dni;
    private String nombre;
    private String apellido;

    public clsEMantenimiento() {
    }

    public clsEMantenimiento(int id_maquina, int emp_con, String numero, String tipo, String estado, String observaciones, String fecha, String dni, String nombre, String apellido) {
        this.id_maquina = id_maquina;
        this.emp_con = emp_con;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public int getEmp_con() {
        return emp_con;
    }

    public void setEmp_con(int emp_con) {
        this.emp_con = emp_con;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    
    
}
