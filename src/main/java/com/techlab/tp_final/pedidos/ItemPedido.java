package com.techlab.tp_final.pedidos;

import com.techlab.tp_final.productos.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
@IdClass(ItemPedidoId.class)
public class ItemPedido{
    @Id
    @ManyToOne
    private Pedido pedido;

    @Id
    @Column
    private Producto producto;

    @Column
    private int cantidad;
}
