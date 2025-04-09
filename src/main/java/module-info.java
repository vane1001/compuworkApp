module com.example.evaluacion_desempeno {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.evaluacion_desempeno to javafx.fxml;
    exports com.example.evaluacion_desempeno;
}
