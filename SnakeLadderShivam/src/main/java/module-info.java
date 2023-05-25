module com.example.snakeladdershivam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeladdershivam to javafx.fxml;
    exports com.example.snakeladdershivam;
}