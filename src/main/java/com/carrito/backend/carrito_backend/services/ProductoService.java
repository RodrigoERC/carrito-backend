package com.carrito.backend.carrito_backend.services;

import java.util.List;

import com.carrito.backend.carrito_backend.entities.Producto;

public interface ProductoService {

    List<Producto> findAll();
    
    List<String> existencias();

}