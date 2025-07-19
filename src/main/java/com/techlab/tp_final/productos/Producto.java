package com.techlab.tp_final.productos;

import java.util.List;

import com.techlab.tp_final.pedidos.ItemPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private Double precio;

    @Column
    private Integer cantidad;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<ItemPedido> itemsPedidos;
    
    public void setPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setCantidad(int cantidad){
        if (cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public ProductoResponseDTO asDTO(){
        return new ProductoResponseDTO(nombre, precio);
    }
}
