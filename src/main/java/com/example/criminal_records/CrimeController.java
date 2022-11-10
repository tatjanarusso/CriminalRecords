package com.example.criminal_records;

import com.example.criminal_records.database.DatabaseCommandExecutor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrimeController {
    @FXML private TextField userField;
    @FXML private PasswordField pwField;
    @FXML private Button loginButton;
    @FXML private Button searchButton;
    @FXML private TableView tableView;
    @FXML private TextField forename;
    @FXML private TextField surname;

    private DatabaseCommandExecutor db;

    public CrimeController() {
        db = new DatabaseCommandExecutor();
    }

    @FXML
    protected void onLoginClick() throws IOException, SQLException {
        loginButton.setDisable(true);
        loginCheck(userField.getText(), pwField.getText());
        loginButton.setDisable(false);
    }

    //checks if input is correct and connects to the following page
    private void loginCheck(String user, String pw) throws IOException, SQLException {
        Stage stage = new Stage();
        ResultSet userResultset =  db.getFiltered("users", "users.user_name=\"" + user + "\" AND users.password=\"" + pw + "\"");
        if(userResultset.isBeforeFirst()){
            System.out.println("Welcome police man");
            FXMLLoader fxmlLoader = new FXMLLoader(CrimeApplication.class.getResource("police-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1500, 600);
            stage.setTitle("Hello Police!");
            stage.setScene(scene);
            stage.show();
        }
        else {
            System.out.println("Wrong password or user");
        }

    }

    //Button function for the pages
    @FXML
    protected void onSearchClick(){
        searchButton.setDisable(true);
        List<Person> people = new ArrayList<>();
        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty()){
            people = setPeople(db.getTable("criminals"), db);
        }
        else if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty()){
            people = setPeople(db.getFiltered("criminals", "criminals.first_name=\"" + forename.getText() + "\""), db);
        }
        else if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty() != true){
            people = setPeople(db.getFiltered("criminals", "criminals.last_name=\"" + surname.getText() + "\""), db);
        }
        else if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty() != true){
            people = setPeople(db.getFiltered("criminals", "criminals.first_name=\"" + forename.getText() + "\" and last_name=\"" + surname.getText() + "\""), db);
        }

        // Setting data for Tableview
        for (Person person : people) {
            tableView.getItems().add(person);
        }
        searchButton.setDisable(false);

    }

    @FXML
    protected void onClearClick(){
        tableView.getItems().clear();
    }

    private List<Person> setPeople(ResultSet resultSet, DatabaseCommandExecutor db){
        List<Person> personList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Person person = new Person ();
                String comCrime = "";
                String sentence = "";
                String weapon =  "";
                ResultSet resultsetCrime = db.getFiltered("crime", " crime_id=" + resultSet.getInt ("crime_id"));
                while(resultsetCrime.next()) {
                    comCrime += resultsetCrime.getString (2);
                    sentence += resultsetCrime.getString(3);
                    weapon += resultsetCrime.getString(6);
                }
                person.setCrimes(comCrime);
                person.setWeapon(weapon);
                person.setSentence(sentence);

                personList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return personList;
    }

}