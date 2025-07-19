package com.techlab.tp_final.pedidos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoResponseDTO{
    private String nombreProducto;
    private Integer cantidad;
    private Double precio;
}
