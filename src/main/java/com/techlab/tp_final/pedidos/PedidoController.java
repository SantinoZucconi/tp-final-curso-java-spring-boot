package com.techlab.tp_final.pedidos;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.tp_final.excepciones.ItemNotFoundException;
import com.techlab.tp_final.excepciones.StockInsuficienteException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {
    private PedidoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PedidoResponseDTO createProducto(@RequestBody PedidoCreateDTO pedidoDTO) throws ItemNotFoundException, StockInsuficienteException{
        return service.createPedido(pedidoDTO).toDTO();
    }
}
