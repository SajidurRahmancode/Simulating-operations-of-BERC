/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.User;

/**
 * FXML Controller class
 *
 * @author sajid
 */
public class signupcontroller implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox userTypeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        userTypeComboBox.getItems().addAll("chairman", "Employee", "Lawyer", "Tariff officer","Consumer" ,"Finance officer","District Manager","Government Authorities");

        userTypeComboBox.setValue("chairman");
    }    

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException 
    {
 
        
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String usertype = userTypeComboBox.getValue().toString();

        User u = new User() {};
            
            
        if (u.isUsernameRegistered(username)) {
            // Show an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username already exists");
            alert.setContentText("Please enter a unique username.");
            alert.showAndWait();
            return;
        }
        if (username.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Username not given");
            a.setContentText("Please enter a unique username.");
            a.showAndWait();
            return;
         
        }
        if (password.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("password not given");
            a.setContentText("Please enter a password");
            a.showAndWait();
            return;
        }    
        if (username.length() < 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username must be at least 4 digits or characters");
            alert.setContentText("Please enter a username that is at least 4 characters");
            alert.showAndWait();
            return;
        }
        if (password.length() < 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password must be at least 4 digits or more");
            alert.setContentText("Please enter a password that is at least 4 characters");
            alert.showAndWait();
            return; 
        }else{     
            try {
                // Register the user
                u.register(username, password, usertype);
            } catch (FileNotFoundException e) {
                // Handle the FileNotFoundException here
                e.printStackTrace();
            }
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
            alert.setTitle("");
            alert.setHeaderText("Account creation successful");
            alert.setContentText("Please try logging in");
            alert.showAndWait();
        
        
        
        } 
        
        
        
        
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("homeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void setUserInfoButtonOnAction(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("executiveCommitteeSetUserInfo_g2.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
    
}
