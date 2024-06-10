package com.carrito.backend.carrito_backend.services;

import java.util.List;
import java.util.Map;

import com.carrito.backend.carrito_backend.entities.Venta;

public interface VentaService {

    List<Venta> findAll();

    List<Map<String, Object>> findReport();
}