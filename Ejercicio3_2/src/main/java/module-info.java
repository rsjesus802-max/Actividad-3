module com.mycompany.ejercicio3_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejercicio3_2 to javafx.fxml;
    exports com.mycompany.ejercicio3_2;
}
