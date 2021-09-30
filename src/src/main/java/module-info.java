module com.example.criminalrecords {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.criminalrecords to javafx.fxml;
    exports com.example.criminalrecords;
}