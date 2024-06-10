package com.carrito.backend.carrito_backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrito.backend.carrito_backend.entities.Venta;
import com.carrito.backend.carrito_backend.repositories.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService{
    
    @Autowired
    private VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }
    
    @Override
    @Transactional
    public List<Venta> findAll(){
        return (List) this.ventaRepository.findAll();
    }
    
    public List<Map<String, Object>>  findReport(){
        return ventaRepository.findReport();    
    }
}
