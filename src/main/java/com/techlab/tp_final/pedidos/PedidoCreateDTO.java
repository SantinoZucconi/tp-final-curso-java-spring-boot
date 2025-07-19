package com.techlab.tp_final.pedidos;

import java.util.List;

public record PedidoCreateDTO(
    List<ItemPedidoCreateDTO> productos
        ) {
    Pedido toPedido(List<ItemPedido> productos) {
        return Pedido.builder()
            .productos(productos)
            .build();
    }
}
