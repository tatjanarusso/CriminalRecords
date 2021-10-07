module com.example.criminalrecords {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.criminalrecords to javafx.fxml;
    exports com.project.criminalrecords;
}