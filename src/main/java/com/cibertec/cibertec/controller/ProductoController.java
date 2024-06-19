package com.cibertec.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.cibertec.entity.Producto;
import com.cibertec.cibertec.service.ProductoService;

@RestController
@RequestMapping("/url/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping("/listaProductos")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("buscarPorId/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Producto producto = productoService.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(producto);
        }
    }

    @PostMapping("/registrar")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto updatedProducto = productoService.updateProducto(id, producto);
        if (updatedProducto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedProducto);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> EliminarProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }


    
}
