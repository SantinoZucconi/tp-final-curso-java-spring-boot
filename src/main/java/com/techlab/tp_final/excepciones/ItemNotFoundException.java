package com.techlab.tp_final.excepciones;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String entity) {
        super(String.format("Failed to find %s", entity));
    }
}
