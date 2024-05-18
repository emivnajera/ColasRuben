package com.example.colas;
import java.time.LocalDateTime;
import java.util.Random;

class Cliente {
    private int articulos;
    private String nombre;
    private int correlativo;
    private int tiempoDeAtencion;
    private LocalDateTime horaDeAtencion;
    private double tiempoEspera;

    // Constructor
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.articulos = (int) (Math.random() * 10) + 1;
        this.correlativo = 0;
        this.tiempoDeAtencion = 0;
        this.horaDeAtencion = null;
        this.tiempoEspera = 0;
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para articulos
    public int getArticulos() {
        return articulos;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }

    // Métodos getter y setter para correlativo
    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    // Métodos getter y setter para tiempoDeAtencion
    public int getTiempoDeAtencion() {
        return tiempoDeAtencion;
    }

    public void setTiempoDeAtencion(int tiempoDeAtencion) {
        this.tiempoDeAtencion = tiempoDeAtencion;
    }

    // Métodos getter y setter para horaDeAtencion
    public LocalDateTime getHoraDeAtencion() {
        return horaDeAtencion;
    }

    public void setHoraDeAtencion(LocalDateTime horaDeAtencion) {
        this.horaDeAtencion = horaDeAtencion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", articulos=" + articulos +
                ", correlativo=" + correlativo +
                ", tiempoDeAtencion=" + tiempoDeAtencion +
                ", horaDeAtencion=" + horaDeAtencion +
                ", tiempoEspera=" + tiempoEspera +
                '}';
    }

    public double getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(double tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
}