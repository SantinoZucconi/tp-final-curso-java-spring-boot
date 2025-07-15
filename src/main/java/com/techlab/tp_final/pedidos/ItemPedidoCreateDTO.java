package com.techlab.tp_final.pedidos;

import com.techlab.tp_final.productos.Producto;

public record ItemPedidoCreateDTO(
        String nombreProducto,
        Integer cantidad
        ){
    public ItemPedido toItemPedido(Producto producto){
        return ItemPedido.builder()
            .producto(producto)
            .cantidad(cantidad)
            .build();
    }
}

