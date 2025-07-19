package com.techlab.tp_final.pedidos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.tp_final.excepciones.ItemNotFoundException;
import com.techlab.tp_final.excepciones.StockInsuficienteException;
import com.techlab.tp_final.productos.Producto;
import com.techlab.tp_final.productos.ProductoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProductoService productoService;

    public Pedido createPedido(PedidoCreateDTO pedidoCreateDTO) throws ItemNotFoundException, StockInsuficienteException{
        List<ItemPedido> productos = new ArrayList<ItemPedido>();

        Pedido newPedido = Pedido.builder().total(0.0).build();
        Pedido pedido = pedidoRepository.save(newPedido);

        for (ItemPedidoCreateDTO itemPedido : pedidoCreateDTO.productos()) {
            Producto producto = productoService.getProductoById(itemPedido.idProducto());
            if (producto.getCantidad() < itemPedido.cantidad()) {
                pedidoRepository.delete(pedido);
                throw new StockInsuficienteException();
            }
            ItemPedido item = itemPedido.toItemPedido(producto,pedido);
            productos.add(item);
        }

        for (ItemPedido itemPedido : productos) {
            productoService.takeStock(itemPedido.getProducto(), itemPedido.getCantidad());
            itemPedidoRepository.save(itemPedido);
        }

        pedido.setProductos(productos);
        pedido.calcularTotal();
        return pedidoRepository.save(pedido);
    }
}
