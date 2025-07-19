package com.techlab.tp_final.pedidos;

import com.techlab.tp_final.productos.Producto;

public record ItemPedidoCreateDTO(
        Long idProducto,
        Integer cantidad
        ){
    public ItemPedido toItemPedido(Producto producto,Pedido pedido){
        return ItemPedido.builder()
            .idProducto(idProducto)
            .idPedido(pedido.getId())
            .pedido(pedido)
            .producto(producto)
            .cantidad(cantidad)
            .build();
    }
}

