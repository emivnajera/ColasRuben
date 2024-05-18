package com.example.colas;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField numClientesField;
    @FXML
    private Label welcomeText;
    @FXML
    private ProgressBar progressBar;

    private int numClientes = 0;
    private ArrayList<String> nombresClientes = new ArrayList<>();
    private Cola colaDeClientes;
    private Caja caja1 = new Caja();
    private Caja caja2 = new Caja();
    private boolean cajasAtendiendo = false;

    @FXML
    protected void onConfirmarNumeroClientes() {
        try {
            numClientes = Integer.parseInt(numClientesField.getText());
            welcomeText.setText("Número de clientes establecido a: " + numClientes);
            mostrarModalNombreCliente();
        } catch (NumberFormatException e) {
            welcomeText.setText("Por favor, ingrese un número válido.");
        }
    }

    private void mostrarModalNombreCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nombreCliente.fxml"));
            Parent root = loader.load();

            NombreClienteController nombreClienteController = loader.getController();
            nombreClienteController.setHelloController(this);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Agregar nombre del cliente");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarNombreCliente(String nombreCliente) {
        if (!nombreCliente.isEmpty()) {
            nombresClientes.add(nombreCliente);
            if (nombresClientes.size() == numClientes) {
                welcomeText.setText("Todos los clientes han sido ingresados.");

                // Crear la cola de clientes
                colaDeClientes = new Cola(nombresClientes);

                // Iniciar la simulación de las cajas atendiendo
                if (!cajasAtendiendo) {
                    iniciarCajasAtendiendo();
                }
            } else {
                mostrarModalNombreCliente();
            }
        }
    }


    private void atenderClienteEnCaja(Cliente cliente) {
        // Simular el tiempo de atención
        try {
            Thread.sleep(cliente.getArticulos() * 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void iniciarCajasAtendiendo() {
        cajasAtendiendo = true;
        // Crear dos hilos para las cajas
        Thread caja1Hilo = new Thread(() -> {
            while (!colaDeClientes.estaVacia()) {
                caja1.atenderCliente(colaDeClientes);
            }
        });
        Thread caja2Hilo = new Thread(() -> {
            while (!colaDeClientes.estaVacia()) {
                caja2.atenderCliente(colaDeClientes);
            }
        });

        // Iniciar los hilos
        caja1Hilo.start();
        caja2Hilo.start();
    }
}
