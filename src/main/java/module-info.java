module com.example.criminal_records {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.criminal_records to javafx.fxml, javafx.base;
    exports com.example.criminal_records;
    exports com.example.criminal_records.util;
    opens com.example.criminal_records.util to javafx.fxml;
}