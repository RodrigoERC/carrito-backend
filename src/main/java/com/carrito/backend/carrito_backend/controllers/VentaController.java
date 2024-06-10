package com.carrito.backend.carrito_backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.backend.carrito_backend.entities.Venta;
import com.carrito.backend.carrito_backend.services.VentaService;

@CrossOrigin(origins={"http://localhost:8080"})
@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> list() {
        return ventaService.findAll();
    }

    @GetMapping("/findReport")
    public List<Map<String, Object>> findReport() {
        return ventaService.findReport();
    }
}
