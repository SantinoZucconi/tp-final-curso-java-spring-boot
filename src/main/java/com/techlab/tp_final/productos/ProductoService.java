package com.techlab.tp_final.productos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techlab.tp_final.excepciones.ItemAlreadyExistsException;
import com.techlab.tp_final.excepciones.ItemNotFoundException;

@Service
public class ProductoService {

    private ProductoRepository repository;

    public Producto createProducto(ProductoSaveDTO productoDTO) throws ItemAlreadyExistsException{
        if (repository.existsByName(productoDTO.nombre())){
            throw new ItemAlreadyExistsException("producto");
        }
        return repository.save(productoDTO.toProducto());
    }

    public Producto updateProducto(ProductoSaveDTO productoDTO) throws ItemNotFoundException{
        if (!repository.existsByName(productoDTO.nombre())){
            throw new ItemNotFoundException("producto");
        }
        return repository.save(productoDTO.toProducto());
    }

    public void deleteProducto(Long productoId) throws ItemNotFoundException{
        if (!repository.existsById(productoId)){
            throw new ItemNotFoundException("producto");
        }
        repository.deleteById(productoId);
    }

    public Producto getProductoById(Long productoId) throws ItemNotFoundException{
        Optional<Producto> maybeProducto = repository.findById(productoId);
        if (maybeProducto.isEmpty()){
            throw new ItemNotFoundException("producto");
        }
        return maybeProducto.get();
    }

    public List<Producto> getProductos(){
        return repository.findAll();
    }
}
