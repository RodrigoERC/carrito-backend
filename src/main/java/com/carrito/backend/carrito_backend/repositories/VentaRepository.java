package com.carrito.backend.carrito_backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.carrito.backend.carrito_backend.entities.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {

    @Query(value = " SELECT  p.IDProductos, p.Titulo, p.Existencias,"+
                   " IF(p.Existencias < 100, 'Pocas Existencias', 'Disponible') AS estado,"+ 
                   " IFNULL(SUM(v.CantidadVendida), 0) AS ventasPorArticulo,"+
                   " (IFNULL(SUM(v.CantidadVendida), 0) * p.PrecioUnitario) AS ingresoPorArticulo, "+
                   " (SELECT SUM(v1.CantidadVendida * p1.PrecioUnitario) FROM Ventas v1 "+
                   " INNER JOIN Productos p1 ON v1.IDProductos = p1.IDProductos) AS ventasGlobales," +
                   " (SELECT p2.Titulo FROM Productos p2" +   
                   " INNER JOIN Ventas v2 ON p2.IDProductos = v2.IDProductos" +
                   " GROUP BY p2.IDProductos ORDER BY SUM(v2.CantidadVendida) DESC LIMIT 1) AS articuloMasVendido " +
                   " FROM Productos p " + 
                   " LEFT JOIN Ventas v ON p.IDProductos = v.IDProductos" + 
                   " GROUP BY p.IDProductos, p.Titulo, p.PrecioUnitario, p.Existencias ORDER BY ventasPorArticulo DESC", nativeQuery = true)

    List<Map<String, Object>> findReport();

}
