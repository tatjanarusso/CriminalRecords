package com.example.criminal_records;

import com.example.criminal_records.database.DatabaseCommandExecutor;
import com.example.criminal_records.database.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
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
    @FXML private Button clearButton;
    @FXML private TableColumn selected;
    @FXML private TableView tableView;
    @FXML private TextField forename;
    @FXML private TextField surname;

    //Login view
    @FXML
    protected void onLoginClick() throws IOException {
       loginButton.setDisable(true);
       loginCheck(userField.getText(), pwField.getText());
       loginButton.setDisable(false);
    }

    //checks if input is correct and connects to the following page
    private void loginCheck(String user, String pw) throws IOException {
        //Users
        String userPolice = "police";
        String userCivil = "civil";
        //pws
        String pwPolice = "police1";
        String pwCivil = "civil1";
        Stage stage = new Stage();

        if(userCivil.equals(user) && pwCivil.equals(pw)){
            System.out.println("Welcome civil man!");
            FXMLLoader fxmlLoader = new FXMLLoader(CrimeApplication.class.getResource("civil-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1500, 600);
            stage.setTitle("Hello Civil!");
            stage.setScene(scene);
            stage.show();
        }
        else if(userPolice.equals(user) && pwPolice.equals(pw)){
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
        DatabaseCommandExecutor db = new DatabaseCommandExecutor ();

        selected.setCellFactory(CheckBoxTableCell.forTableColumn(selected));

        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty()){
            ObservableList<Person> people = setPeople(db.getTable("criminals"), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty()){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText()), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty() != false){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "last_name=" + surname.getText()), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty() != true){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText() + " and last_name=" + surname.getText()), db);
            tableView.setItems(people);
        }
        searchButton.setDisable(false);

    }

    private ObservableList<Person> setPeople(ResultSet resultSet, DatabaseCommandExecutor db){
        ObservableList<Person> personList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()){
                Person person = new Person ();
                person.setForeName(resultSet.getString("first_name"));
                person.setSurname (resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                person.setAge(resultSet.getInt("height"));
                person.setAge(resultSet.getInt("weight"));

                //getting crime
                ResultSet crime = db.getFiltered("crime", " crime_id=" + resultSet.getInt ("crime_id"));
                String crimeString = crime.getString("crime") + " weapon" + crime.getString ("weapon");

                person.setCrimes(crimeString);

                personList.add(person, person.getForeName(), person.getSurname (), person.getAge(), person.getHeight(), person.getWeight(), person.getCrimes());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return personList;
    }

    @FXML
    protected void onClearClick(){
        searchButton.setDisable(true);
        DatabaseCommandExecutor db = new DatabaseCommandExecutor ();

        selected.setCellFactory(CheckBoxTableCell.forTableColumn(selected));

        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty()){
            ObservableList<Person> people = setPeople(db.getTable("criminals"), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty()){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText()), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty() != false){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "last_name=" + surname.getText()), db);
            tableView.setItems(people);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty() != true){
            ObservableList<Person> people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText() + " and last_name=" + surname.getText()), db);
            tableView.setItems(people);
        }
        searchButton.setDisable(false);

    }
}