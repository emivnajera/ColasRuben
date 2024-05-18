package com.example.colas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Caja {
    // Otros atributos y métodos...
    private List<Cliente> clientesAtendidos;


    public Caja() {
        this.clientesAtendidos = new ArrayList<>();
    }
    public void atenderCliente(Cola colaDeClientes) {
        Cliente cliente = colaDeClientes.obtenerProximoCliente();
        if (cliente != null) {
            cliente.setHoraDeAtencion(LocalDateTime.now());
            cliente.setTiempoEspera(Math.random()*5);
            int tiempoDeAtencion = cliente.getArticulos() * 2;
            cliente.setTiempoDeAtencion(tiempoDeAtencion);

            try {
                // Simular el tiempo de atención
                Thread.sleep(tiempoDeAtencion * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (clientesAtendidos) {
                clientesAtendidos.add(cliente);
            }

            System.out.println("Cliente atendido: " + cliente);
        } else {
            System.out.println("No hay clientes para atender en esta cola.");
            Estadistica estadisticas = new Estadistica(clientesAtendidos);
            System.out.println("Estadisticas: " + estadisticas);
        }
    }
}
