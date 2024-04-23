package com.dylan.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dylan.apirest.apirest.Repositories.ProductoRepositorie;
import com.dylan.apirest.apirest.Entities.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepositorie productoRepositorie;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepositorie.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el ID: " + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepositorie.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el ID: " + id));

        producto.setNombreProducto(productoDetails.getNombreProducto());
        producto.setCantidad(productoDetails.getCantidad());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepositorie.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepositorie.findById(id)
                 .orElseThrow(()-> new RuntimeException("No se encontró el producto con el ID: " + id));

        productoRepositorie.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }
}
