package com.example.colas;

import java.util.List;

public class Estadistica {
   private List<Cliente> clientesAtendidos;
   private double tiempoEsperaPromedio;
   private double tiempoAtencionPromedio;
   private double tiempoMaximo;

   public Estadistica(List<Cliente> clientesAtendidos) {
      this.clientesAtendidos = clientesAtendidos;
      calcularEstadisticas();
   }

   private void calcularEstadisticas() {
      if (clientesAtendidos == null || clientesAtendidos.isEmpty()) {
         tiempoEsperaPromedio = 0;
         tiempoAtencionPromedio = 0;
         tiempoMaximo = 0;
         return;
      }

      double sumaTiempoEspera = 0;
      double sumaTiempoAtencion = 0;
      double maxTiempoAtencion = Double.MIN_VALUE;

      for (Cliente cliente : clientesAtendidos) {
         double tiempoEspera = cliente.getTiempoEspera();
         double tiempoAtencion = cliente.getTiempoDeAtencion();

         sumaTiempoEspera += tiempoEspera;
         sumaTiempoAtencion += tiempoAtencion;

         if (tiempoAtencion > maxTiempoAtencion) {
            maxTiempoAtencion = tiempoAtencion;
         }
      }

      tiempoEsperaPromedio = sumaTiempoEspera / clientesAtendidos.size();
      tiempoAtencionPromedio = sumaTiempoAtencion / clientesAtendidos.size();
      tiempoMaximo = maxTiempoAtencion;
   }

   public double getTiempoEsperaPromedio() {
      return tiempoEsperaPromedio;
   }

   public double getTiempoAtencionPromedio() {
      return tiempoAtencionPromedio;
   }

   public double getTiempoMaximo() {
      return tiempoMaximo;
   }

   @Override
   public String toString() {
      return "Estadisticas de Atención:" +
              "\nTiempo de Espera Promedio: " + tiempoEsperaPromedio + " segundos" +
              "\nTiempo de Atención Promedio: " + tiempoAtencionPromedio + " segundos" +
              "\nTiempo Máximo de Atención: " + tiempoMaximo + " segundos";
   }
}
