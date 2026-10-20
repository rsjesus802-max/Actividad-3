package com.mycompany.ejercicio3_1conteo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtClics;

    @FXML
    private Button btnContar;

    @FXML
    private Button btnEsperar;

    @FXML
    private ProgressBar progressBar;

    private int clics = 1;

    @FXML
    private void contarClic() {
        clics++;
        txtClics.setText(String.valueOf(clics));
    }

    @FXML
    private void iniciarEspera() {
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);

        new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(100); // 100ms * 100 = 10 segundos
                    final double progreso = i / 100.0;
                    Platform.runLater(() -> progressBar.setProgress(progreso));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> btnEsperar.setDisable(false));
        }).start();
    }
}