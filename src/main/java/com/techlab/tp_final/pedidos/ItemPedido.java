package com.techlab.tp_final.pedidos;

import com.techlab.tp_final.productos.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ItemPedidoId.class)
public class ItemPedido{
    @Id
    private Long idPedido;

    @Id
    private Long idProducto;

    @ManyToOne
    @MapsId("idPedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idProducto")
    private Producto producto;

    @Column
    private int cantidad;

    public Double getPrecio(){
        return producto.getPrecio();
    }

    public ItemPedidoResponseDTO toDTO(){
        return ItemPedidoResponseDTO.builder()
            .nombreProducto(producto.getNombre())
            .cantidad(cantidad)
            .precio(producto.getPrecio() * cantidad)
            .build();
    }
}
