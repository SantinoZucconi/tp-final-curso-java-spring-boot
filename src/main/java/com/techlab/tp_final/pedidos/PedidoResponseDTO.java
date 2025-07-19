package com.techlab.tp_final.pedidos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO{
    private Double total;
    private List<ItemPedidoResponseDTO> productos;
}
