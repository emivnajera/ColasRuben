package com.example.colas;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NombreClienteController {
    @FXML
    private TextField nombreClienteField;

    private HelloController helloController;

    public void setHelloController(HelloController mainController) {
        this.helloController = mainController;
    }

    @FXML
    protected void onAgregarNombre() {
        String nombreCliente = nombreClienteField.getText();
        if (!nombreCliente.isEmpty()) {
            helloController.agregarNombreCliente(nombreCliente);
            Stage stage = (Stage) nombreClienteField.getScene().getWindow();
            stage.close();
        }
    }
}
