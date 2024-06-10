package com.carrito.backend.carrito_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.backend.carrito_backend.entities.Producto;
import com.carrito.backend.carrito_backend.services.ProductoService;

@CrossOrigin(origins={"http://localhost:8080"})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> list() {
        return productoService.findAll();
    }

    @GetMapping("/existencias")
    public List<String> existencias() {
        return productoService.existencias();
    }

}
