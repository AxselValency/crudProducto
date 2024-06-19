package com.cibertec.cibertec.service;

import java.util.List;

import com.cibertec.cibertec.entity.Producto;

public interface ProductoService {
     List<Producto> getAllProductos();
    Producto getProductoById(int id);
    Producto createProducto(Producto producto);
    Producto updateProducto(int id, Producto producto);
    void deleteProducto(int id);
    
}
