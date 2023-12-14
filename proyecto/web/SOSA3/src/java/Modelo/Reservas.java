/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Reservas {
    
    private int id; 
    private String cliente_dni;
    private int maquinas_id; 
    private String fechareserva;
    private String fecha_entrada;
    private String fecha_salida;
    private String estado; 
    private int ptotal; 
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCliente_dni() {
        return cliente_dni;
    }

    public void setCliente_dni(String cliente_dni) {
        this.cliente_dni = cliente_dni;
    }
    
    public int getMaquinas_id() {
        return maquinas_id;
    }

    public void setMaquinas_id(int maquinas_id) {
        this.maquinas_id = maquinas_id;
    }
    
    public String getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(String fechareserva) {
        this.fechareserva = fechareserva;
    }
    
    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    
    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
   

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    public int getPtotal() {
        return ptotal;
    }

    public void setPtotal(int ptotal) {
        this.ptotal = ptotal;
    }
    
    public Reservas() {
    }

    
    public Reservas(int id,String cliente_dni, int maquinas_id,String fechareserva, String fecha_entrada, String fecha_salida, String estado, int ptotal) {
        this.id = id;
        this.cliente_dni = cliente_dni;
        this.maquinas_id = maquinas_id;
        this.fechareserva = fechareserva;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
        this.ptotal = ptotal;
    }
    
    
    
    
    
    
    
}
