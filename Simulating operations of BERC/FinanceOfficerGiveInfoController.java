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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerGiveInfoController implements Initializable {

    @FXML
    private ComboBox<String> departmentcombo;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextArea textarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          departmentcombo.getItems().addAll("chairman", "Employee", "Lawyer", "Tariff officer", "Consumer","Finance officer","District Manager","Government Authorities");
        // TODO
    }    

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinanceOfficerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void sendbutton(ActionEvent event) throws IOException {
               Boolean addstatus= 
                FinanceOfficer.giveinfo(
                      
                        departmentcombo.getValue(),
                        datepicker.getValue(),
                        textarea.getText()
                        

                );
        if(addstatus){

            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Your Given Information is Sent to the particular department");
            a.showAndWait();
        }
        else{

            Alert a =new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.showAndWait();
        
    }
    
        }
    
    
    
}
