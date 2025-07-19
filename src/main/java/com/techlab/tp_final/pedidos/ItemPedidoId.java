package com.techlab.tp_final.pedidos;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoId{
    private Long idPedido;
    private Long idProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoId that = (ItemPedidoId) o;
        return Objects.equals(idPedido, that.idPedido) &&
               Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idProducto);
    }
}
