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
    @FXML private TableColumn selected;
    @FXML private TableView tableView;
    @FXML private TextField forename;
    @FXML private TextField surname;

    private boolean isPolice = false;

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
            isPolice = true;

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

        List<Person> people = new ArrayList<>();

        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty()){
            people = setPeople(db.getTable("criminals"), db);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty()){
            people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText()), db);
        }
        if(forename.getText().trim().isEmpty() && surname.getText().trim().isEmpty() != false){
            people = setPeople(db.getFiltered("criminals", "last_name=" + surname.getText()), db);
        }
        if(forename.getText().trim().isEmpty() != true && surname.getText().trim().isEmpty() != true){
            people = setPeople(db.getFiltered("criminals", "first_name=" + forename.getText() + " and last_name=" + surname.getText()), db);
        }

        // Setting data for Tableview
        for (Person person : people) {
            tableView.getItems().add(person);
        }
        searchButton.setDisable(false);

    }

    @FXML
    protected void onClearClick(){
        tableView.getItems ().clear ();
    }

    private List<Person> setPeople(ResultSet resultSet, DatabaseCommandExecutor db){
        List<Person> personList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Person person = new Person ();
                person.setForeName(resultSet.getString("first_name"));
                person.setSurname (resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                person.setAge(resultSet.getInt("height"));
                person.setAge(resultSet.getInt("weight"));

                //getting crime if Officer, else censor the crime
                String comCrime = "";
                String sentence = "";
                String weapon =  "";
                if(isPolice){
                    ResultSet crime = db.getFiltered("crime", " crime_id=" + resultSet.getInt ("crime_id"));
                    comCrime = crime.getString("crime") + " weapon" + crime.getString ("crime");
                    sentence = crime.getString("crime") + " weapon" + crime.getString ("weapon");
                    weapon = crime.getString("crime") + " weapon" + crime.getString ("sentence");
                } else {

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