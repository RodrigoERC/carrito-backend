package com.carrito.backend.carrito_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDProductos;
    

    private String titulo;
    private String descripcion;
    
    @Column(name = "PrecioUnitario")
    private double precioUnitario;

    private int existencias;

    public Producto(){

    }

    public Producto(Long iDProductos, String titulo, String descripcion, double precioUnitario, int existencias) {
        IDProductos = iDProductos;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.existencias = existencias;
    }
    public Long getIDProductos() {
        return IDProductos;
    }
    public void setIDProductos(Long iDProductos) {
        IDProductos = iDProductos;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
   
    

    
    
}
