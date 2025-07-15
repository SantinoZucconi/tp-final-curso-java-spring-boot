package com.techlab.tp_final.productos;

public record ProductoSaveDTO(
    String nombre,
    Double precio,
    Integer cantidad
        ) {
    Producto toProducto() {
        return Producto.builder()
            .nombre(nombre)
            .precio(precio)
            .cantidad(cantidad)
            .build();
    }
}
