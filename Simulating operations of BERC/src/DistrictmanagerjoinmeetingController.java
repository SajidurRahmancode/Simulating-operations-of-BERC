/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.SetMeeting;
/**
 * FXML Controller class
 *
 * @author sajid
 */
public class DistrictmanagerjoinmeetingController implements Initializable {

    @FXML
    private DatePicker selectDatePicker;
    @FXML
    private ComboBox<?> selectTypeCombo;
    @FXML
    private ComboBox<?> selectSetByCombo2;
    @FXML
    private TextField meetingTypeTextField;
    @FXML
    private TextField meetingDateTextField;
    @FXML
    private TextField meetingTimeTextField;
    @FXML
    private TextField meetingLocationTextField;
    @FXML
    private TextField setByTextField1;
    @FXML
    private TextField meetingLinkTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savebtn(ActionEvent event) {
        String meetingType = meetingTypeTextField.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("meeting.txt"))) {
            writer.write(meetingType);
            System.out.println("Meeting type saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error saving meeting type to file: " + e.getMessage());
        }
    }

    @FXML
    private void backButtonclickOnAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("District Manager home scene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    
}
