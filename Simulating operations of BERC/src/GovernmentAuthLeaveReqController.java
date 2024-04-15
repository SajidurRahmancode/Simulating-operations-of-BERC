/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.FileHandling;
import modelclass.Member;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GovernmentAuthLeaveReqController implements Initializable {

    @FXML
    private TextArea messageBodyTextField;
    @FXML
    private TextField summaryTextField;
    @FXML
    private ComboBox<String> employeeidcombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendRequestButtonOnAction(ActionEvent event) throws IOException {
        
        
        
        
        Boolean addstatus= 
                FileHandling.CreateFile(
                        //String meetingLocation, String meetingLink, String meetingType, String meetingTime, String setby, LocalDate meetingDate
                        employeeidcombobox.getValue(),
                         summaryTextField.getText(),
                        messageBodyTextField.getText(),
                        "DM_leaveRequest.bin"
                        
                       
                        


                );
        if(addstatus){

            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("New Leave Request Added Sucussfully");
            a.showAndWait();
        }
        else{

            Alert a =new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.showAndWait();
        
    }
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("governmentAuthHomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }
    
}
