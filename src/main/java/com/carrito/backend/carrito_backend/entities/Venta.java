package com.carrito.backend.carrito_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDVentas;

    @Column(name = "CantidadVendida")
    private int cantidadVendida;

    private String fecha;

    @ManyToOne
    @JoinColumn(name = "IDProductos") 
    private Producto producto;

    public Venta() {

    }

    public Venta(Long iDVentas, int cantidadVendida, String fecha, Producto producto) {
        IDVentas = iDVentas;
        this.cantidadVendida = cantidadVendida;
        this.fecha = fecha;
        this.producto = producto;
    }

    public Long getIDVentas() {
        return IDVentas;
    }

    public void setIDVentas(Long iDVentas) {
        IDVentas = iDVentas;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
