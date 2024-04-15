/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DistrictManagerFileaCaseController implements Initializable {

    @FXML
    private TextArea caseTextArea;
    @FXML
    private TextField nametextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    

    @FXML
    private void sendCaseButtonOnAction(ActionEvent event) {
        
          String caseContent = caseTextArea.getText();
        String caseagainstName = nametextfield.getText();
        
        if (caseContent.isEmpty() || caseagainstName.isEmpty()) {
            showAlert("Error", "Please fill in both fields.");
            return;
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("case.txt", true))) {
            writer.println("case against Name: " + caseagainstName);
            writer.println("Case Content: " + caseContent);
            writer.println("-------------------------------------");
            showAlert("Success", "successfully written to file.");
        } catch (IOException e) {
            showAlert("Error", "Failed to write case to file: " + e.getMessage());
        }
        
        
        
        
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("District Manager home scene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

     private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
