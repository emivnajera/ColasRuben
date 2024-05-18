package com.example.colas;

class Nodo {
    Cliente cliente;
    Nodo siguiente;

    Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}