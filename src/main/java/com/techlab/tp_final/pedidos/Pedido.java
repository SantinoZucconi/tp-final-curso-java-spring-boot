package com.techlab.tp_final.pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ItemPedido> productos;

    @Column
    private Double total;

    public void calcularTotal(){
        Double total = 0.0;
        for (ItemPedido itemPedido : productos) {
            total += itemPedido.getCantidad() * itemPedido.getPrecio();
        }
        this.total = total;
    }

    public PedidoResponseDTO toDTO(){
        return PedidoResponseDTO.builder()
            .total(total)
            .productos(productos.stream().map(x -> x.toDTO()).collect(Collectors.toList()))
            .build();
    }
}
