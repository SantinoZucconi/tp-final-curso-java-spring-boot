package com.techlab.tp_final.pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Pedido{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ItemPedido> productos;

    @Column
    private double total;
}
