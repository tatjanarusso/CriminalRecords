package com.project.criminalrecords;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CrimeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrimeApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Login");

        //Grid setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //create scene
        Scene scene = new Scene(grid, 500, 575);

        //Input fields
        Text scenetitle = new Text("Login:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0,0,2,1);

        //Input user
        Label user = new Label("User:");
        grid.add(user, 0,1);
        TextField userfield = new TextField();
        userfield.setPromptText("Enter\\your\\user");
        grid.add(userfield,1,1);

        //Input target
        Label password = new Label("Password:");
        grid.add(password, 0, 2);
        PasswordField passwordfield = new PasswordField();
        passwordfield.setPromptText("password");
        grid.add(passwordfield, 1,2);

        //Button Login
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 2, 9);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 9);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle( ActionEvent e) {
                //actiontarget.setFill(Color.FIREBRICK);
                //actiontarget.setText("Searching directories...");

                //checks if inputfield is empty or not
                if ((userfield.getText() != null && !userfield.getText().isEmpty())) {

                    //converts input to String
                    String userinput = userfield.getText();
                    String passwordinput = passwordfield.getText();

                    //gives elements to class
                    String logintext = "";
                    String txt = login.check(userinput, passwordinput, logintext);
                    System.out.println(txt);

                    actiontarget.setText(txt);

                }
                //if there's not input
                else {
                    actiontarget.setText("No input");
                }
                
            }

        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
