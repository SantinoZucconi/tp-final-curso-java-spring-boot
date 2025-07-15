package com.techlab.tp_final.productos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private double precio;

    @Column
    private int cantidad;
    
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
