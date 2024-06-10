package com.carrito.backend.carrito_backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carrito.backend.carrito_backend.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
