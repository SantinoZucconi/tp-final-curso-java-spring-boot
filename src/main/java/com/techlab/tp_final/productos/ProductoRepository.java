package com.techlab.tp_final.productos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public boolean existsByNombre(String name);
}
