package com.example.colas;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int contadorCorrelativo;

    // Constructor
    public Cola(ArrayList<String> nombres) {
        this.frente = null;
        this.fin = null;
        this.contadorCorrelativo = 0;

        for (String nombre : nombres) {
            if (nombre != null && !nombre.isEmpty()) {
                agregarCliente(new Cliente(nombre));
            }
        }
    }

    // Método para agregar un cliente a la cola
    public void agregarCliente(Cliente cliente) {
        cliente.setCorrelativo(this.contadorCorrelativo++);
        Nodo nuevoNodo = new Nodo(cliente);
        if (fin != null) {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo;
        }
        System.out.println("Cliente agregado: " + cliente);
    }

    // Método para atender (eliminar) al primer cliente de la cola
    public Cliente atenderCliente() {
        if (frente == null) {
            System.out.println("No hay clientes en la cola para atender.");
            return null;
        }
        Cliente clienteAtendido = frente.cliente;
        frente = frente.siguiente;
        clienteAtendido.setHoraDeAtencion(LocalDateTime.now());
        clienteAtendido.setTiempoDeAtencion((int) (Math.random() * 30) + 1); // Ejemplo de tiempo de atención
        if (frente == null) {
            fin = null;
        }
        System.out.println("Cliente atendido: " + clienteAtendido);
        return clienteAtendido;
    }

    // Método para ver al primer cliente de la cola sin atenderlo
    public Cliente verProximoCliente() {
        if (frente == null) {
            return null;
        }
        return frente.cliente;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return this.contadorCorrelativo == 0;
    }
    public Cliente obtenerProximoCliente() {
        if (frente == null) {
            return null;
        }
        Cliente cliente = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        this.contadorCorrelativo--;
        return cliente;
    }

    public static void main(String[] args) {
        // Inicializar la cola con un arreglo de nombres
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Alice");
        nombres.add("");
        nombres.add("Bob");
        nombres.add("Charlie");
        Cola Cola = new Cola(nombres);

        // Atender a algunos clientes
        Cola.atenderCliente();
        Cola.atenderCliente();

        // Ver el próximo cliente sin atenderlo
        Cliente proximoCliente = Cola.verProximoCliente();
        if (proximoCliente != null) {
            System.out.println("Próximo cliente a ser atendido: " + proximoCliente);
        }

        // Atender al siguiente cliente
        Cola.atenderCliente();

        // Verificar si la cola está vacía
        if (Cola.estaVacia()) {
            System.out.println("No hay más clientes en la cola.");
        }
    }

    public int contarClientes() {
        int contador = 0;
        Nodo actual = frente;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}