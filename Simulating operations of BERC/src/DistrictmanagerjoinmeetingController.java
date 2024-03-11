/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) {
    }
    
}
