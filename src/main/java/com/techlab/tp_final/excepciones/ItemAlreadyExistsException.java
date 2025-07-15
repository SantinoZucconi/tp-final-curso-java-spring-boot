package com.techlab.tp_final.excepciones;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(String entity) {
        super(String.format("This %s already exists", entity));
    }
}
