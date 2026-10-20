package com.mycompany.ejercicio3_2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class CarreraController {

    @FXML private ProgressBar barLiebre;
    @FXML private ProgressBar barTortuga;
    @FXML private Label lblLiebre;
    @FXML private Label lblTortuga;
    @FXML private Button btnIniciar;

    @FXML
    private void iniciarCarrera() {
        btnIniciar.setDisable(true);
        barLiebre.setProgress(0.0);
        barTortuga.setProgress(0.0);
        lblLiebre.setText("¡Corriendo!");
        lblTortuga.setText("¡Está corriendo!");

        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                final double progreso = i / 100.0;
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> barTortuga.setProgress(progreso));
            }
            Platform.runLater(() -> lblTortuga.setText("¡Llegó a la meta!"));
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                final double progreso = i / 100.0;
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> barLiebre.setProgress(progreso));
            }

            Platform.runLater(() -> lblLiebre.setText("La Liebre: ¡Se durmió!"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> lblLiebre.setText("La Liebre: ¡Despertó y corre!"));
            for (int i = 31; i <= 100; i++) {
                final double progreso = i / 100.0;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> barLiebre.setProgress(progreso));
            }
            
            Platform.runLater(() -> {
                lblLiebre.setText("La Liebre: ¡Llegó!");
                btnIniciar.setDisable(false);
            });
        }).start();
    }
}