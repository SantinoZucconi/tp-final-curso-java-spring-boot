package com.techlab.tp_final.excepciones;

public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(){
        super("Stock insuficiente");
    }
}
