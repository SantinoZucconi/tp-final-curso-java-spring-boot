package com.techlab.tp_final.productos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.tp_final.excepciones.ItemAlreadyExistsException;
import com.techlab.tp_final.excepciones.ItemNotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

    private ProductoService service;

    @GetMapping
    public List<ProductoResponseDTO> getProductos(){
        return service.getProductos().stream().map(producto -> producto.asDTO()).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public ProductoResponseDTO getProductoById(@PathVariable Long id) throws ItemNotFoundException{
        return service.getProductoById(id).asDTO();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductoResponseDTO createProducto(@RequestBody ProductoSaveDTO productoDTO) throws ItemAlreadyExistsException{
        return service.createProducto(productoDTO).asDTO();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductoResponseDTO updateProducto(@RequestBody ProductoSaveDTO productoDTO) throws ItemNotFoundException{
        return service.updateProducto(productoDTO).asDTO();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProducto(@PathVariable Long id) throws ItemNotFoundException{
        service.deleteProducto(id);
    }
}
