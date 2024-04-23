package com.dylan.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dylan.apirest.apirest.Entities.Producto;

public interface ProductoRepositorie extends JpaRepository<Producto, Long> {

    

}
