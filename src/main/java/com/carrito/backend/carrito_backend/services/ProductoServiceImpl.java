package com.carrito.backend.carrito_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrito.backend.carrito_backend.entities.Producto;
import com.carrito.backend.carrito_backend.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List) this.productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> existencias() {
        List<Producto> productos = findAll();
        List<String> mensajes = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getExistencias() < 100) {
                String mensaje = "El producto " + producto.getTitulo() + " tiene menos de 100 unidades.";
                mensajes.add(mensaje);
                System.out.println(mensaje);
            }
        }
        return mensajes;
    }

}
